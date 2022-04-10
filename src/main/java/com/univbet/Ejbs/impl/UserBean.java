package com.univbet.Ejbs.impl;

import com.univbet.DTO.UserDto;
import com.univbet.Ejbs.User;
import com.univbet.Entities.UserEntity;
import com.univbet.Enums.Role;
import com.univbet.Listener.ApplicationListener;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;

@Stateless
public class UserBean implements User {
    @Override
    public void login(UserDto user) throws IOException {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        UserEntity userEntity = em.createNamedQuery("findLogin", UserEntity.class).
                setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).getSingleResult();
        if(userEntity != null) {
            if(userEntity.getRole() == Role.ADMIN) {
                FacesContext.getCurrentInstance().getExternalContext().dispatch("accueilAdmin.jsf");
            }
            else {
                FacesContext.getCurrentInstance().getExternalContext().dispatch("accueilAdmin.jsf");
            }
        }
    }

    @Override
    public void signIn(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(user.getFirstnameUser());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(Role.NORMAL_USER);

        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(userEntity);
        em.getTransaction().commit();
        em.close();
    }
}
