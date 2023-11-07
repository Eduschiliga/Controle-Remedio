package com.example.trabalhocontroleremedio;

public class Usuario {
    private String login;
    private String senha;
    private String tipo;
    private String nome;
    private String telefone;
    private int matricula;

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public Usuario(){
        this.login = null;
        this.senha = null;
        this.tipo = null;
        this.nome = null;
        this.telefone = null;
        this.matricula = 0;
    }

    public void adicionarUsuario(String login, String senha, String tipo, String nome, String telefone, int matricula){ // Adiciona usuário ao banco
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public void alterarUsuario(String login, String senha, String tipo, String nome, String telefone, int matricula){ // Altera o usuário no banco
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public void excluirUsuario(){ // Exclui usuário do banco
        this.login = null;
        this.senha = null;
        this.tipo = null;
        this.nome = null;
        this.telefone = null;
        this.matricula = 0;
    }

    @Override
    public String toString(){
        return "Usuário:\nLogin: " + this.login + "\nSenha: " + this.senha + "\nTipo: " + this.tipo + "\nNome: " + this.nome +
                "\nTelefone: " + this.telefone + "\nMatricula: " + this.matricula;
    }
}