package com.example.trabalhocontroleremedio;

public class UsuarioDAO extends AbstrataDAO<UsuarioJPAController, Usuario>{
    
    public UsuarioDAO(){
        objetoJPA = new UsuarioJPAController(getEntityManagerFactory());
    }

    @Override
    public void cadastrar(Usuario objeto) throws Exception{
        objetoJPA.criar(objeto);
    }
}
