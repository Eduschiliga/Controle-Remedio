package com.example.trabalhocontroleremedio.banco;

import java.util.List;

import com.example.trabalhocontroleremedio.modelo.Idoso;

public class IdosoDAO extends AbstrataDAO<IdosoJPAController, Idoso>{
    
    public IdosoDAO(){
        objetoJPA = new IdosoJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(Idoso objeto) throws Exception{
        objetoJPA.criar(objeto);
    }

    @Override
    public void editar(Idoso objeto) throws Exception{
        objetoJPA.editar(objeto);
    }

    @Override
    public void excluir(Idoso objeto) throws Exception{
        objetoJPA.deletar(objeto.getIdIdoso());
    }

    @Override
    public Idoso buscar(Idoso objeto){
        return objetoJPA.encontrarIdoso(objeto.getIdIdoso());
    }

    @Override
    public List<Idoso> buscarTodos(){
        return objetoJPA.encontrarEntidadesIdoso();
    }

    public Idoso buscarNome(Idoso objeto){
        return objetoJPA.encontrarIdosoNome(objeto.getNome());
    }

    public Idoso buscarUltimoIdoso(){
        return objetoJPA.encontrarUltimoIdoso();
    }
}
