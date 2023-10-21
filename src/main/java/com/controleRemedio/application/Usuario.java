package com.controleRemedio.application;

public class Usuario {
    private String login;
    private String senha;
    private int tipoUsuario;
    private String nome;
    private String telefone;
    private int matricula;

    public Usuario(String login, String senha, int tipoUsuario, String nome, String telefone, int matricula){
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
    }
}
