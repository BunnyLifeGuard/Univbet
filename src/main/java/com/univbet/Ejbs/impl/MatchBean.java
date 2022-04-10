package com.univbet.Ejbs.impl;

import com.univbet.DTO.MatchDto;
import com.univbet.Ejbs.Match;
import com.univbet.Entities.MatchEntity;
import com.univbet.Enums.Status;
import com.univbet.Listener.ApplicationListener;
import org.checkerframework.checker.units.qual.A;

import javax.ejb.Stateless;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MatchBean implements Match {

    @Override
    public void addGame(MatchDto match) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setEquipeA(match.getEquipeA());
        matchEntity.setEquipeB(match.getEquipeB());
        matchEntity.setStatus(Status.valueOf(match.getStatus()));

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(matchEntity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<MatchDto> getMatches() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        Query query =em.createNamedQuery("findAllGames", MatchEntity.class);
        List<MatchEntity> matchEntities = query.getResultList();

        List<MatchDto> toReturn = new ArrayList<>();
        matchEntities.forEach(match-> toReturn.add(new MatchDto(match)));
        return toReturn;
    }

    @Override
    public void updateStatus(ValueChangeEvent event, long id) {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNamedQuery("updateStatus", MatchEntity.class).setParameter("id", id).
                setParameter("status", event.getNewValue().toString());

        int rowsUpdated = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<MatchDto> getOldGames() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("findThreeOldGames", MatchEntity.class);
        List<MatchEntity> matchEntities = query.setMaxResults(3).getResultList();

        List<MatchDto> toReturn = new ArrayList<>();
        matchEntities.forEach(match-> toReturn.add(new MatchDto(match)));
        return toReturn;
    }

    @Override
    public List<MatchDto> getNewGames() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("findThreeNewGames", MatchEntity.class);
        List<MatchEntity> matchEntities = query.setMaxResults(3).getResultList();

        List<MatchDto> toReturn = new ArrayList<>();
        matchEntities.forEach(match-> toReturn.add(new MatchDto(match)));
        return toReturn;
    }
}
