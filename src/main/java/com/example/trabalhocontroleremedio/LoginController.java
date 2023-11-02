package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController {
    private Login usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button entrar;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    void entrar(ActionEvent event) {
        boolean validacao;
        usuario = new Login();
        validacao = usuario.buscar(login.getText(),senha.getText());
        if(validacao){
            HelloApplication.trocarTela("Principal");
        }else{
            System.out.println("Usuário ou senha errados");
        }
    }

    @FXML
    void initialize() {
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert senha != null : "fx:id=\"senha\" was not injected: check your FXML file 'Login.fxml'.";

    }

}
