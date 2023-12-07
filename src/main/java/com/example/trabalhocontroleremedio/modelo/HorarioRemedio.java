package com.example.trabalhocontroleremedio.modelo;

public class HorarioRemedio {
    
    private String horario;
    private String segunda;
    private String terca;
    private String quarta;
    private String quinta;
    private String sexta;
    private String sabado;
    private String domingo;

    public HorarioRemedio(String horario, String segunda, String terca, String quarta, String quinta, String sexta, String sabado, String domingo){
        this.horario = horario;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    @Override
    public String toString(){
        return horario + " | " + segunda + " | " + terca + " | " + quarta + " | " + quinta + " | " + sexta + " | " + sabado + " | " + domingo;
    }
}
