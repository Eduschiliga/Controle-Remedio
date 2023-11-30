package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class PrincipalController {

    private Parent fxmlUsuario = null;
    private Parent fxmlIdoso = null;
    private Parent fxmlRemedio = null;
    private Parent fxmlRemedioIdoso = null;
    private Parent fxmlVisualizar = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane principal;

    @FXML
    void visualizar(ActionEvent event) {
        setTela("Visualizar");
    }

    @FXML
    void cadastrarIdoso(ActionEvent event) {
        setTela("Idoso");
    }

    @FXML
    void cadastrarRemedio(ActionEvent event) {
        setTela("Remedio");
    }

    @FXML
    void cadastrarUsuario(ActionEvent event) {
        setTela("Usuario");
    }

    @FXML
    void vincular(ActionEvent event) {
        setTela("RemedioIdoso");
    }


    @FXML
    void telas(KeyEvent event) {
        if(event.getCode() == KeyCode.F1){
            visualizar(null);
        }
        if(event.getCode() == KeyCode.F2){
            cadastrarUsuario(null);
        }
        if(event.getCode() == KeyCode.F3){
            cadastrarIdoso(null);
        }
        if(event.getCode() == KeyCode.F4){
            cadastrarRemedio(null);
        }
        if(event.getCode() == KeyCode.F5){
            vincular(null);
        }
    }

    private void setTela(String tela){
        switch (tela) {
            case "Usuario":
                principal.setCenter(fxmlUsuario);
                break;
            
            case "Idoso":
                principal.setCenter(fxmlIdoso);
                break;
            
            case "Remedio":
                principal.setCenter(fxmlRemedio);
                break;
            
            case "RemedioIdoso":
                principal.setCenter(fxmlRemedioIdoso);
                break;
            
            case "Visualizar":
                principal.setCenter(fxmlVisualizar);
                break;
        }
    }


    @FXML
    void initialize() {
        principal.setCenter(null);
        try {
            //fxmlUsuario = FXMLLoader.load(getClass().getResource("CadastrarUsuario.fxml"));
            fxmlIdoso = FXMLLoader.load(getClass().getResource("CadastrarIdoso.fxml"));
            fxmlRemedio = FXMLLoader.load(getClass().getResource("CadastrarRemedio.fxml"));
            fxmlRemedioIdoso = FXMLLoader.load(getClass().getResource("CadastrarRemedioIdoso.fxml"));
            fxmlVisualizar = FXMLLoader.load(getClass().getResource("VisualizarRemedioIdoso.fxml"));
            principal.setCenter(fxmlVisualizar);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
