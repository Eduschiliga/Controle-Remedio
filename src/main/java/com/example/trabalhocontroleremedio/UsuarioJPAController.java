package com.example.trabalhocontroleremedio;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UsuarioJPAController implements Serializable{
    
    private EntityManagerFactory emf = null;

    public UsuarioJPAController(EntityManagerFactory emf){
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public Usuario encontrarUsuario(int matricula){
        EntityManager em = getEntityManager();
        try{
            return em.find(Usuario.class, matricula);
        }finally{
            em.close();
        }
    }

    public void criar(Usuario usuario) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }catch (Exception ex){
            if(encontrarUsuario(Usuario.getMatricula()) != null){
                throw new Exception("Usuário " + usuario + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
}
