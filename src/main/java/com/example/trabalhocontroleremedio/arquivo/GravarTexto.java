package com.example.trabalhocontroleremedio.arquivo;

import java.io.IOException;

public class GravarTexto {
    private Arquivo arquivo;

    public GravarTexto(String arquivo){
        this.arquivo = new Arquivo(arquivo);
    }

    public void inserirTexto(String texto){
        try{
            this.arquivo.gravarLinhaTexto(texto);
        }catch(IOException IOEx){
            System.out.println("Impossível inserir texto no arquivo\n" + IOEx);
        }
    }
}
