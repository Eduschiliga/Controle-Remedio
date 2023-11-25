package com.example.trabalhocontroleremedio.arquivo;

import java.io.*;

public class Arquivo {
    private String nomeArq;
    private BufferedWriter arqSaida;

    public Arquivo(String arquivo){
        this.nomeArq = arquivo;
    }

    public void gravarLinhaTexto(String linha) throws IOException{
        try{
            if(this.arqSaida == null){
                abreArqGravacao();
            }
            this.arqSaida.write(linha);
            this.arqSaida.newLine();
            fechaArqGravacao();
        }catch(IOException IOEx){
            throw new IOException(IOEx);
        }
    }

    private void abreArqGravacao() throws IOException{
        try{
            if(this.arqSaida == null){
                this.arqSaida = new BufferedWriter(new FileWriter(new File(this.nomeArq), true));
            }
        }catch(IOException IOEx){
            throw new IOException(IOEx);
        }
    }

    private void fechaArqGravacao() throws IOException{
        try{
            if(this.arqSaida != null){
                this.arqSaida.close();;
            }
            this.arqSaida = null;
        }catch(IOException IOEx){
            throw new IOException(IOEx);
        }
    }
}