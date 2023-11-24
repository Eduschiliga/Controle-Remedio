package com.example.trabalhocontroleremedio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

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
            if(encontrarUsuario(usuario.getMatricula()) != null){
                throw new Exception("Usuário " + usuario + " já existente.",ex);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void editar(Usuario usuario) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
        }catch(Exception ex){
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                int matricula = usuario.getMatricula();
                if(encontrarUsuario(matricula) == null){
                    throw new Exception("O produto com matrícula " + matricula + " não existe.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void deletar(int matricula) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try{
                usuario = em.getReference(Usuario.class, matricula);
                usuario.getMatricula();
            }catch(EntityNotFoundException enfe){
                throw new Exception("O usuario com matricula " + matricula + " não existe.",enfe);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    private List<Usuario> encontrarEntidadesUsuario(boolean tudo, int maximoResultados, int primeiroResultado){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public List<Usuario> encontrarEntidadesUsuario(int maximoResultados, int primeiroResultado){
        return encontrarEntidadesUsuario(false,maximoResultados,primeiroResultado);
    }

    public List<Usuario> encontrarEntidadesUsuario(){
        return encontrarEntidadesUsuario(true, -1, -1);
    }
}
