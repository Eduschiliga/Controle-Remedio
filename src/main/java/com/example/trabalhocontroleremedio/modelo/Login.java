package com.example.trabalhocontroleremedio.modelo;

import com.example.trabalhocontroleremedio.banco.UsuarioDAO;

public class Login {
    private static String login;
    private static String senha;
    private static Usuario usuario;
    private static UsuarioDAO jpa;

    public static boolean buscar(){ // Busca o usuário no banco para verificação
        usuario = new Usuario();
        jpa = new UsuarioDAO();
        usuario.setLogin(Login.login);
        usuario.setSenha(Login.senha);
        try{
            //usuario = jpa.buscarMatricula(usuario);
            usuario.setLogin("admin");
            usuario.setSenha("admin");
            if(Login.login.equals(usuario.getLogin()) && Login.senha.equals(usuario.getSenha())){
                return true;
            }
            return false;
        }catch(NullPointerException NPE){
            return false;
        }
    }

    public static void setLogin(String login){
        Login.login = login;
    }

    public static void setSenha(String senha){
        Login.senha = senha;
    }

    public static String getLogin(){
        return Login.login;
    }
}
