package com.controleRemedio.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button entrar;

    @FXML
    void handleButtonAction(ActionEvent event) {
        System.out.println("Entrando");
    }

    @FXML
    void initialize() {
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'Login.fxml'.";

    }

}
