package com.example.trabalhocontroleremedio;

import javax.persistence.EntityManagerFactory;

public abstract class AbstrataDAO<J,E> implements InterfaceDAO<J,E> {
    
    J objetoJPA;

    public J getObjetoJPA(){
        return objetoJPA;
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory(){
        return JPAUtils.getEntityManagerFactory();
    }
}
