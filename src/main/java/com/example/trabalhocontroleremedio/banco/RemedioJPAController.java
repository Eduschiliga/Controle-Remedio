package com.example.trabalhocontroleremedio.banco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.example.trabalhocontroleremedio.modelo.Remedio;

public class RemedioJPAController implements Serializable{

    private EntityManagerFactory emf = null;

    public RemedioJPAController(EntityManagerFactory emf){
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public Remedio encontrarRemedio(int idRemedio){
        EntityManager em = getEntityManager();
        try{
            return em.find(Remedio.class, idRemedio);
        }finally{
            em.close();
        }
    }

    public void criar(Remedio remedio) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(remedio);
            em.getTransaction().commit();
        }catch (Exception ex){
            if(encontrarRemedio(remedio.getIdRemedio()) != null){
                throw new Exception("Remedio " + remedio + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void editar(Remedio remedio) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            remedio = em.merge(remedio);
            em.getTransaction().commit();
        }catch(Exception ex){
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                int idRemedio = remedio.getIdRemedio();
                if(encontrarRemedio(idRemedio) == null){
                    throw new Exception("O produto com matrícula " + idRemedio + " não existe.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void deletar(int idRemedio) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Remedio remedio;
            try{
                remedio = em.getReference(Remedio.class, idRemedio);
                remedio.getIdRemedio();
            }catch(EntityNotFoundException enfe){
                throw new Exception("O Remedio com idRemedio " + idRemedio + " não existe.",enfe);
            }
            em.remove(remedio);
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    private List<Remedio> encontrarEntidadesRemedio(boolean tudo, int maximoResultados, int primeiroResultado){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Remedio.class));
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

    public List<Remedio> encontrarEntidadesRemedio(int maximoResultados, int primeiroResultado){
        return encontrarEntidadesRemedio(false,maximoResultados,primeiroResultado);
    }

    public List<Remedio> encontrarEntidadesRemedio(){
        return encontrarEntidadesRemedio(true, -1, -1);
    }

    public Remedio encontrarRemedioNome(String nome){
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("SELECT r FROM Remedio r WHERE r.nome = :nome", Remedio.class).setParameter("nome", nome).getSingleResult();
        }catch(NoResultException NRE){
            System.out.println("Remedio não encontrado");
            return null;
        }finally{
            em.close();
        }
    }
}
