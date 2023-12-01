package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.trabalhocontroleremedio.modelo.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CadastrarRemedioIdosoController {

    @FXML
    private Button buscar;

    @FXML
    private Button cadastrar;

    @FXML
    private Spinner<?> dias;

    @FXML
    private TextField dosagem;

    @FXML
    private Button editar;

    @FXML
    private Button excluir;

    @FXML
    private TextField idoso;

    @FXML
    private TextField remedio;

    @FXML
    void buscar(ActionEvent event) {
        
    }

    @FXML
    void cadastrar(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " cadastrou remédio idoso");
    }

    @FXML
    void editar(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " editou remédio idoso");
    }

    @FXML
    void excluir(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " excluiu remédio idoso");
    }

    @FXML
    void initialize() {
        assert buscar != null : "fx:id=\"buscar\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert cadastrar != null : "fx:id=\"cadastrar\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert dias != null : "fx:id=\"dias\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert dosagem != null : "fx:id=\"dosagem\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert excluir != null : "fx:id=\"excluir\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert idoso != null : "fx:id=\"idoso\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
        assert remedio != null : "fx:id=\"remedio\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";
    }

}
