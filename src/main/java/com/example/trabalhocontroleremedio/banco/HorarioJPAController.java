package com.example.trabalhocontroleremedio.banco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.example.trabalhocontroleremedio.modelo.Horario;

public class HorarioJPAController implements Serializable{
    
    private EntityManagerFactory emf = null;

    public HorarioJPAController(EntityManagerFactory emf){
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public Horario encontrarHorario(int idHorario){
        EntityManager em = getEntityManager();
        try{
            return em.find(Horario.class, idHorario);
        }finally{
            em.close();
        }
    }

    public void criar(Horario horario) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(horario);
            em.getTransaction().commit();
        }catch (Exception ex){
            if(encontrarHorario(horario.getIdhorario()) != null){
                throw new Exception("Horario " + horario + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void editar(Horario horario) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            horario = em.merge(horario);
            em.getTransaction().commit();
        }catch(Exception ex){
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                int idHorario = horario.getIdhorario();
                if(encontrarHorario(idHorario) == null){
                    throw new Exception("O produto com matrícula " + idHorario + " não existe.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void deletar(int idHorario) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Horario horario;
            try{
                horario = em.getReference(Horario.class, idHorario);
                horario.getIdhorario();
            }catch(EntityNotFoundException enfe){
                throw new Exception("O Horario com idHorario " + idHorario + " não existe.",enfe);
            }
            em.remove(horario);
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    private List<Horario> encontrarEntidadesHorario(boolean tudo, int maximoResultados, int primeiroResultado){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horario.class));
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

    public List<Horario> encontrarEntidadesHorario(int maximoResultados, int primeiroResultado){
        return encontrarEntidadesHorario(false,maximoResultados,primeiroResultado);
    }

    public List<Horario> encontrarEntidadesHorario(){
        return encontrarEntidadesHorario(true, -1, -1);
    }
}
