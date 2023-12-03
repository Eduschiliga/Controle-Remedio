package com.example.trabalhocontroleremedio.banco;

import java.util.List;

import com.example.trabalhocontroleremedio.modelo.RemedioIdoso;

public class RemedioIdosoDAO extends AbstrataDAO<RemedioIdosoJPAController, RemedioIdoso>{
    
    public RemedioIdosoDAO(){
        objetoJPA = new RemedioIdosoJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(RemedioIdoso objeto) throws Exception{
        objetoJPA.criar(objeto);
    }

    @Override
    public void editar(RemedioIdoso objeto) throws Exception{
        objetoJPA.editar(objeto);
    }

    @Override
    public void excluir(RemedioIdoso objeto) throws Exception{
        objetoJPA.deletar(objeto.getIdRemedioIdoso());
    }

    @Override
    public RemedioIdoso buscar(RemedioIdoso objeto){
        return objetoJPA.encontrarRemedioIdoso(objeto.getIdRemedioIdoso());
    }

    @Override
    public List<RemedioIdoso> buscarTodos(){
        return objetoJPA.encontrarEntidadesRemedioIdoso();
    }

    public RemedioIdoso buscarRemedioIdosoNome(String nome){
        return objetoJPA.encontrarRemedioIdosoNome(nome);
    }
}
