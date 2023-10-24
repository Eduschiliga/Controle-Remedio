package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastrarUsuarioController {

    private Usuario user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button alterar;

    @FXML
    private Button buscar;

    @FXML
    private Button cadastrar;

    @FXML
    private Button excluir;

    @FXML
    private TextField login;

    @FXML
    private TextField matricula;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField telefone;

    @FXML
    private ComboBox<?> usuario;

    @FXML
    void inserir(ActionEvent event) {
        user = new Usuario(login.getText(), senha.getText(), 0, nome.getText(), telefone.getText(), 0);
    }

    @FXML
    void imprimir(ActionEvent event) {
        System.out.println(user.toString());
    }

    @FXML
    void initialize() {
        assert alterar != null : "fx:id=\"alterar\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert buscar != null : "fx:id=\"buscar\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert cadastrar != null : "fx:id=\"cadastrar\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert excluir != null : "fx:id=\"excluir\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert matricula != null : "fx:id=\"matricula\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert senha != null : "fx:id=\"senha\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert telefone != null : "fx:id=\"telefone\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'CadastrarUsuario.fxml'.";

    }

}
