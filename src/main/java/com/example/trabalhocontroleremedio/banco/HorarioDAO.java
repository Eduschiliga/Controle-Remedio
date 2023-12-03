package com.example.trabalhocontroleremedio.banco;

import java.util.List;

import com.example.trabalhocontroleremedio.modelo.Horario;

public class HorarioDAO extends AbstrataDAO<HorarioJPAController, Horario>{
    
    public HorarioDAO(){
        objetoJPA = new HorarioJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(Horario objeto) throws Exception{
        objetoJPA.criar(objeto);
    }

    @Override
    public void editar(Horario objeto) throws Exception{
        objetoJPA.editar(objeto);
    }

    @Override
    public void excluir(Horario objeto) throws Exception{
        objetoJPA.deletar(objeto.getIdhorario());
    }

    @Override
    public Horario buscar(Horario objeto){
        return objetoJPA.encontrarHorario(objeto.getIdhorario());
    }

    @Override
    public List<Horario> buscarTodos(){
        return objetoJPA.encontrarEntidadesHorario();
    }
}
