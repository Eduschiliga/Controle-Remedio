package com.example.trabalhocontroleremedio;

public class Login {
    private String login;
    private String senha;

    public Login(){
        this.login = "admin";
        this.senha = "admin";
    }

    public boolean buscar(String login, String senha){
        if(this.login.equals(login) && this.senha.equals(senha)){
            return true;
        }
        return false;
    }
}
