package com.example.trabalhocontroleremedio.banco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.example.trabalhocontroleremedio.modelo.Idoso;

public class IdosoJPAController implements Serializable{
    
    private EntityManagerFactory emf = null;

    public IdosoJPAController(EntityManagerFactory emf){
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public Idoso encontrarIdoso(int idIdoso){
        EntityManager em = getEntityManager();
        try{
            return em.find(Idoso.class, idIdoso);
        }finally{
            em.close();
        }
    }

    public void criar(Idoso idoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(idoso);
            em.getTransaction().commit();
        }catch (Exception ex){
            if(encontrarIdoso(idoso.getIdIdoso()) != null){
                throw new Exception("Idoso " + idoso + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void editar(Idoso idoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            idoso = em.merge(idoso);
            em.getTransaction().commit();
        }catch(Exception ex){
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                int idIdoso = idoso.getIdIdoso();
                if(encontrarIdoso(idIdoso) == null){
                    throw new Exception("O produto com matrícula " + idIdoso + " não existe.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void deletar(int idIdoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Idoso idoso;
            try{
                idoso = em.getReference(Idoso.class, idIdoso);
                idoso.getIdIdoso();
            }catch(EntityNotFoundException enfe){
                throw new Exception("O idoso com idIdoso " + idIdoso + " não existe.",enfe);
            }
            em.remove(idoso);
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    private List<Idoso> encontrarEntidadesIdoso(boolean tudo, int maximoResultados, int primeiroResultado){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Idoso.class));
            Query q = em.createQuery(cq);
            if(!tudo){
                q.setMaxResults(maximoResultados);
                q.setFirstResult(primeiroResultado);
            }
            return q.getResultList();
        }finally{
            em.close();
        }
    }

    public List<Idoso> encontrarEntidadesIdoso(int maximoResultados, int primeiroResultado){
        return encontrarEntidadesIdoso(false,maximoResultados,primeiroResultado);
    }

    public List<Idoso> encontrarEntidadesIdoso(){
        return encontrarEntidadesIdoso(true, -1, -1);
    }

    public Idoso encontrarIdosoNome(String nome){
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("SELECT i FROM Idoso i WHERE i.nome = :nome", Idoso.class).setParameter("nome", nome).getSingleResult();
        }catch(NoResultException NRE){
            System.out.println("Idoso não encontrado");
            return null;
        }finally{
            em.close();
        }
    }
}
