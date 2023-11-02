package com.example.trabalhocontroleremedio;

public class Login {
    private String login;
    private String senha;

    private Login(){
        this.login = "Marcos";
        this.senha = "Potato";
    }

    public boolean buscar(String login, String senha){
        if(this.login == login && this.senha == senha){
            return true;
        }
        return false;
    }
}
