package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cadastrarIdoso;

    @FXML
    private Button cadastrarIdosoRemedio;

    @FXML
    private Button cadastrarRemedio;

    @FXML
    private Button cadastrarUsuario;

    @FXML
    private Button login;

    @FXML
    private BorderPane panel;

    @FXML
    void cadastrarIdoso(ActionEvent event) {
        HelloApplication.trocarTela("Idoso");
    }

    @FXML
    void cadastrarIdosoRemedio(ActionEvent event) {
        HelloApplication.trocarTela("RemedioIdoso");
    }

    @FXML
    void cadastrarRemedio(ActionEvent event) {
        HelloApplication.trocarTela("Remedio");
    }

    @FXML
    void cadastrarUsuario(ActionEvent event) {
        HelloApplication.trocarTela("Usuario");
    }

    @FXML
    void login(ActionEvent event) {
        HelloApplication.trocarTela("Login");
    }

    @FXML
    void initialize() {
        assert cadastrarIdoso != null : "fx:id=\"cadastrarIdoso\" was not injected: check your FXML file 'Principal.fxml'.";
        assert cadastrarIdosoRemedio != null : "fx:id=\"cadastrarIdosoRemedio\" was not injected: check your FXML file 'Principal.fxml'.";
        assert cadastrarRemedio != null : "fx:id=\"cadastrarRemedio\" was not injected: check your FXML file 'Principal.fxml'.";
        assert cadastrarUsuario != null : "fx:id=\"cadastrarUsuario\" was not injected: check your FXML file 'Principal.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Principal.fxml'.";

    }

}
