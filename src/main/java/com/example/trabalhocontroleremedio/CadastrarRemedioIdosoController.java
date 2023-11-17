package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CadastrarRemedioIdosoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buscar;

    @FXML
    private Button cadastrar;

    @FXML
    private TextField dias;

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
    private Spinner<?> vezesDia;

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

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
        assert vezesDia != null : "fx:id=\"vezesDia\" was not injected: check your FXML file 'CadastrarRemedioIdoso.fxml'.";

    }

}
