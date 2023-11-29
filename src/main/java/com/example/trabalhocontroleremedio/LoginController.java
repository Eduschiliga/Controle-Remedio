package com.example.trabalhocontroleremedio;

import com.example.trabalhocontroleremedio.excecao.CampoVazioExcecao;
import com.example.trabalhocontroleremedio.modelo.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {

    @FXML
    private Button entrar;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private Label excecao;

    @FXML
    void entrar(ActionEvent event) { // Validação de login
        boolean validacao;
        excecao.setVisible(false);
        try{
            if(login.getText().equals("") || senha.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            Login.setLogin(login.getText());
            Login.setSenha(senha.getText());
            validacao = Login.buscar();
            if(validacao){
                HelloApplication.escreverLog("Login: " + login.getText());
                HelloApplication.trocarTela("Principal");
            }else{
                System.out.println("Usuário ou senha errados");
            }
        }catch(CampoVazioExcecao CVE){
            excecao.setText("Campo Login ou Senha vazio!");
            excecao.setVisible(true);
            System.out.println(CVE);
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
