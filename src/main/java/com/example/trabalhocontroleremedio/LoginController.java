package com.example.trabalhocontroleremedio;

import com.example.trabalhocontroleremedio.modelo.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {
    private Login usuario;

    @FXML
    private Button entrar;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    void entrar(ActionEvent event) { // Validação de login
        boolean validacao;
        usuario = new Login();
        validacao = usuario.buscar(login.getText(),senha.getText());
        if(validacao){
            HelloApplication.escreverLog("Login: " + login.getText());
            HelloApplication.trocarTela("Principal");
        }else{
            System.out.println("Usuário ou senha errados");
        }
    }

    @FXML
    void teclas(KeyEvent event) { // Evento para leitura de tecla
        if(event.getCode() == KeyCode.ENTER){
            entrar(null);
        }
    }

    @FXML
    void initialize() {

    }

}
