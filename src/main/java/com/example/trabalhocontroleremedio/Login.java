package com.example.trabalhocontroleremedio;

public class Login {
    private static String login;
    private static String senha;

    public Login(){
        Login.login = "admin";
        Login.senha = "admin";
    }

    public boolean buscar(String login, String senha){ // Busca o usuário no banco para verificação
        if(Login.login.equals(login) && Login.senha.equals(senha)){
            return true;
        }
        return false;
    }

    public static String getLogin(){
        return Login.login;
    }
}
