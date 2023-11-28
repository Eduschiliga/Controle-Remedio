package com.example.trabalhocontroleremedio.modelo;

import com.example.trabalhocontroleremedio.banco.UsuarioDAO;

public class Login {
    private static String login;
    private static String senha;
    private Usuario usuario;
    private UsuarioDAO jpa;

    public Login(String login, String senha){
        Login.login = login;
        Login.senha = senha;
        usuario = new Usuario(Login.login,Login.senha);
        jpa = new UsuarioDAO();
    }

    public boolean buscar(){ // Busca o usuário no banco para verificação
        System.out.println(jpa.buscarMatricula(usuario));
        /*if(Login.login.equals(login) && Login.senha.equals(senha)){
            return true;
        }*/
        return false;
    }

    public static String getLogin(){
        return Login.login;
    }
}
