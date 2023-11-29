package com.example.trabalhocontroleremedio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class PrincipalController {

    private Parent fxmlUsuario = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane principal;

    @FXML
    void alterarTela(KeyEvent event) {
        if(event.getCode() == KeyCode.F1){
            principal.setCenter(fxmlUsuario);
        }
    }

    @FXML
    void initialize() {
        try {
            fxmlUsuario = FXMLLoader.load(getClass().getResource("CadstrarUsuario.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
