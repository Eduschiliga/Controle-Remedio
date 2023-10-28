package com.example.trabalhocontroleremedio;

public class Remedio {
    private String nome;
    private String nomeGenerico;
    private String categoria;
    private int dosagem;
    private String formaDosagem;

    public String getNome() {
        return nome;
    }
    public String getNomeGenerico() {
        return nomeGenerico;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getDosagem() {
        return dosagem;
    }
    public String getFormaDosagem() {
        return formaDosagem;
    }

    public Remedio(){
        this.nome = null;
        this.nomeGenerico = null;
        this.categoria = null;
        this.dosagem = 0;
        this.formaDosagem = null;
    }

    public void adicionarRemedio(String nome, String nomeGenerico, String categoria, int dosagem, String formaDosagem){
        this.nome = nome;
        this.nomeGenerico = nomeGenerico;
        this.categoria = categoria;
        this.dosagem = dosagem;
        this.formaDosagem = formaDosagem;
    }

    public void alterarRemedio(String nome, String nomeGenerico, String categoria, int dosagem, String formaDosagem){
        this.nome = nome;
        this.nomeGenerico = nomeGenerico;
        this.categoria = categoria;
        this.dosagem = dosagem;
        this.formaDosagem = formaDosagem;
    }

    public void excluirRemedio(){
        this.nome = null;
        this.nomeGenerico = null;
        this.categoria = null;
        this.dosagem = 0;
        this.formaDosagem = null;
    }

    @Override
    public String toString(){
        return "Remédio:\nNome: " + this.nome + "\nNome Genérico: " + this.nomeGenerico + "\nCategoria: " + this.categoria + "\nDosagem: " + this.dosagem +
                "\nForma de Dosagem: " + this.formaDosagem;
    }
}
