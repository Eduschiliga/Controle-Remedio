package com.example.trabalhocontroleremedio;

import java.util.Calendar;
import java.util.Date;

import com.example.trabalhocontroleremedio.banco.RemedioIdosoDAO;
import com.example.trabalhocontroleremedio.modelo.RemedioIdoso;

import javafx.fxml.FXML;

public class VisualizarController {
    
    private RemedioIdoso remedioIdoso;
    private String diaSemana;
    private Calendar calendario;
    private RemedioIdosoDAO jpa;

    @FXML
    void initialize() {
        jpa = new RemedioIdosoDAO();
        calendario = Calendar.getInstance();
        calendario.setTime(new Date());
    }
}
