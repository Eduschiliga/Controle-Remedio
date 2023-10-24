package com.example.trabalhocontroleremedio;

public class Usuario {
    private String login;
    private String senha;
    private int tipo;
    private String nome;
    private String telefone;
    private int matricula;

    public Usuario(String login, String senha, int tipo, String nome, String telefone, int matricula){
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public String toString(){
        return "Usuário:\nLogin: " + this.login + "\nSenha: " + this.senha + "\nTipo: " + this.tipo + "\nNome: " + this.nome +
                "\nTelefone: " + this.telefone + "\nMatricula: " + this.matricula;
    }
}