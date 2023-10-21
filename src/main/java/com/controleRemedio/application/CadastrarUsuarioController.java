package com.controleRemedio.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CadastrarUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cadastrar;

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cadastrar != null : "fx:id=\"cadastrar\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";

    }

}
