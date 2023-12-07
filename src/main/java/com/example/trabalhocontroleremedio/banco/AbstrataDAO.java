package com.example.trabalhocontroleremedio.banco;

import javax.persistence.EntityManagerFactory;

//Abstração e Tipos Parametrizados
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
