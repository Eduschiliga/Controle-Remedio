package com.example.trabalhocontroleremedio.banco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.example.trabalhocontroleremedio.modelo.RemedioIdoso;

public class RemedioIdosoJPAController implements Serializable{
    private EntityManagerFactory emf = null;

    public RemedioIdosoJPAController(EntityManagerFactory emf){
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public RemedioIdoso encontrarRemedioIdoso(int idRemedioIdoso){
        EntityManager em = getEntityManager();
        try{
            return em.find(RemedioIdoso.class, idRemedioIdoso);
        }finally{
            em.close();
        }
    }

    public void criar(RemedioIdoso remedioIdoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(remedioIdoso);
            em.getTransaction().commit();
        }catch (Exception ex){
            if(encontrarRemedioIdoso(remedioIdoso.getIdRemedioIdoso()) != null){
                throw new Exception("Remedio_Idoso " + remedioIdoso + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void editar(RemedioIdoso remedioIdoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            remedioIdoso = em.merge(remedioIdoso);
            em.getTransaction().commit();
        }catch(Exception ex){
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                int idRemedioIdoso = remedioIdoso.getIdRemedioIdoso();
                if(encontrarRemedioIdoso(idRemedioIdoso) == null){
                    throw new Exception("O produto com matrícula " + idRemedioIdoso + " não existe.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void deletar(int idRemedioIdoso) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            RemedioIdoso remedioIdoso;
            try{
                remedioIdoso = em.getReference(RemedioIdoso.class, idRemedioIdoso);
                remedioIdoso.getIdRemedioIdoso();
            }catch(EntityNotFoundException enfe){
                throw new Exception("O RemedioIdoso com idRemedioIdoso " + idRemedioIdoso + " não existe.",enfe);
            }
            em.remove(remedioIdoso);
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    private List<RemedioIdoso> encontrarEntidadesRemedioIdoso(boolean tudo, int maximoResultados, int primeiroResultado){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RemedioIdoso.class));
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

    public List<RemedioIdoso> encontrarEntidadesRemedioIdoso(int maximoResultados, int primeiroResultado){
        return encontrarEntidadesRemedioIdoso(false,maximoResultados,primeiroResultado);
    }

    public List<RemedioIdoso> encontrarEntidadesRemedioIdoso(){
        return encontrarEntidadesRemedioIdoso(true, -1, -1);
    }

    public RemedioIdoso encontrarRemedioIdosoNome(String nome){
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("SELECT r FROM RemedioIdoso r WHERE r.fkIdoso.nome = :nome", RemedioIdoso.class).setParameter("nome", nome).getSingleResult();
        }catch(NoResultException NRE){
            System.out.println("Remedio não encontrado");
            return null;
        }finally{
            em.close();
        }
    }
}
