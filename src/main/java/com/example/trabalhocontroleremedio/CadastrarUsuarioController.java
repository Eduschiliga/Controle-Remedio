package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CadastrarUsuarioController {
    private Usuario usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cadastrar;

    @FXML
    void cadastrar(ActionEvent event) {
        this.usuario = new Usuario(null, null, 0, null, null, 0);
    }

    @FXML
    void initialize() {
        assert cadastrar != null : "fx:id=\"cadastrar\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";

    }

}
