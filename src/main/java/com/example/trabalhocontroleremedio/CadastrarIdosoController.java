package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastrarIdosoController {

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
    private DatePicker nascimento;

    @FXML
    private TextField nome;

    @FXML
    private ComboBox<?> sexo;

    @FXML
    void alterar(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " alterou idoso " + this.nome.getText());
    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        System.out.println(nascimento.getValue());
        HelloApplication.escreverLog(Login.getLogin() + " cadastrou idoso " + this.nome.getText());
    }

    @FXML
    void excluir(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " excluiu idoso " + this.nome.getText());
    }

    @FXML
    void initialize() {
        assert alterar != null : "fx:id=\"alterar\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert buscar != null : "fx:id=\"buscar\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert cadastrar != null : "fx:id=\"cadastrar\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert excluir != null : "fx:id=\"excluir\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert nascimento != null : "fx:id=\"nascimento\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";
        assert sexo != null : "fx:id=\"sexo\" was not injected: check your FXML file 'CadastrarIdoso.fxml'.";

    }

}
