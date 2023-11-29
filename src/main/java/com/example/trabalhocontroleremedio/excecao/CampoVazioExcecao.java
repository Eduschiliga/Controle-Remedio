package com.example.trabalhocontroleremedio.excecao;

public class CampoVazioExcecao extends Exception{
    @Override
    public String getMessage(){
        return "O campo selecinado está vazio";
    }
}
