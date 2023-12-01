package com.example.trabalhocontroleremedio.enumeracao;

public enum Dosagem {
    MG("Miligrama"),
    ML("Mililitro");

    private String dosagem;

    private Dosagem(String dosagem){
        this.dosagem = dosagem;
    }

    public String getDosagem(){
        return dosagem;
    }

}
