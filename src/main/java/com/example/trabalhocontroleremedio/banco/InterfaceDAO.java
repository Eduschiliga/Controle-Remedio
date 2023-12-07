package com.example.trabalhocontroleremedio.banco;

import java.util.List;
import javax.persistence.EntityManagerFactory;

//Interface
public interface InterfaceDAO<J,E> {

    public EntityManagerFactory getEntityManagerFactory();
    public void cadastrar(E objeto) throws Exception;
    public void editar(E objeto) throws Exception;
    public void excluir(E objeto) throws Exception;
    public E buscar(E objeto);
    public List<E> buscarTodos();
}
