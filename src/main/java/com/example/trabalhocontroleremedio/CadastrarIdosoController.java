package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CadastrarIdosoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void back(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            HelloApplication.trocarTela("Principal");
        }
    }

    @FXML
    void initialize() {

    }

}
