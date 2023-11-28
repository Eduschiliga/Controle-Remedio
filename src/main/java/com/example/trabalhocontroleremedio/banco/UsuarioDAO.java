package com.example.trabalhocontroleremedio.banco;

import java.util.List;

import com.example.trabalhocontroleremedio.modelo.Usuario;

public class UsuarioDAO extends AbstrataDAO<UsuarioJPAController, Usuario>{
    
    public UsuarioDAO(){
        objetoJPA = new UsuarioJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(Usuario objeto) throws Exception{
        objetoJPA.criar(objeto);
    }

    @Override
    public void editar(Usuario objeto) throws Exception{
        objetoJPA.editar(objeto);
    }

    @Override
    public void excluir(Usuario objeto) throws Exception{
        objetoJPA.deletar(objeto.getMatricula());
    }

    @Override
    public Usuario buscar(Usuario objeto){
        return objetoJPA.encontrarUsuario(objeto.getMatricula());
    }

    @Override
    public List<Usuario> buscarTodos(){
        return objetoJPA.encontrarEntidadesUsuario();
    }

    public Usuario buscarMatricula(Usuario objeto){
        return objetoJPA.encontrarUsuarioLoginSenha(objeto.getLogin());
    }
}
