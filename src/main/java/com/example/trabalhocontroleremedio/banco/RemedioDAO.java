package com.example.trabalhocontroleremedio.banco;

import java.util.List;

import com.example.trabalhocontroleremedio.modelo.Remedio;

public class RemedioDAO extends AbstrataDAO<RemedioJPAController, Remedio>{
    
    public RemedioDAO(){
        objetoJPA = new RemedioJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(Remedio objeto) throws Exception{
        objetoJPA.criar(objeto);
    }

    @Override
    public void editar(Remedio objeto) throws Exception{
        objetoJPA.editar(objeto);
    }

    @Override
    public void excluir(Remedio objeto) throws Exception{
        objetoJPA.deletar(objeto.getIdRemedio());
    }

    @Override
    public Remedio buscar(Remedio objeto){
        return objetoJPA.encontrarRemedio(objeto.getIdRemedio());
    }

    @Override
    public List<Remedio> buscarTodos(){
        return objetoJPA.encontrarEntidadesRemedio();
    }

    public Remedio buscarNome(Remedio objeto){
        return objetoJPA.encontrarRemedioNome(objeto.getNome());
    }
}
