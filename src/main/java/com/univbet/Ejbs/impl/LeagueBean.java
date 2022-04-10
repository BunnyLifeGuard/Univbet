package com.univbet.Ejbs.impl;

import com.univbet.DTO.LeagueDto;
import com.univbet.Ejbs.League;
import com.univbet.Entities.LeagueEntity;
import com.univbet.Listener.ApplicationListener;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Stateless
public class LeagueBean implements League {

    @Override
    public void addLeague(LeagueDto leagueDto) {
        LeagueEntity leagueEntity = new LeagueEntity();
        leagueEntity.setName(leagueDto.getName());

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(leagueEntity);
        em.getTransaction().commit();
        em.close();
    }
}
