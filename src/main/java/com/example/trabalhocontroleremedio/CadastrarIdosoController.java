package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.trabalhocontroleremedio.enumeracao.Sexo;
import com.example.trabalhocontroleremedio.modelo.Idoso;
import com.example.trabalhocontroleremedio.modelo.Login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastrarIdosoController {

    private Idoso idoso;
    //private IdosoDAO jpa;
    private ObservableList<String> listaSexo;

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
    private ChoiceBox<String> sexo;

    @FXML
    void alterar(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " alterou idoso " + this.nome.getText());
    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        idoso.setNome(nome.getText());
        idoso.setNascimento(nascimento.getValue().toString());
        System.out.println(nascimento.getValue());
        HelloApplication.escreverLog(Login.getLogin() + " cadastrou idoso " + this.nome.getText());
    }

    @FXML
    void excluir(ActionEvent event) {
        HelloApplication.escreverLog(Login.getLogin() + " excluiu idoso " + this.nome.getText());
    }

    @FXML
    void initialize() {
        listaSexo = FXCollections.observableArrayList();
        for(Sexo listaSexo: Sexo.values()){
            this.listaSexo.add(listaSexo.getSexo());
        }
        sexo.setItems(listaSexo);
        sexo.setValue("Masculino");
        idoso = new Idoso();
    }

}
