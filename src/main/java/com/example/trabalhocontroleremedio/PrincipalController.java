package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab cadastrarIdoso;

    @FXML
    private Tab cadastrarRemedio;

    @FXML
    private Tab cadastrarRemedioIdoso;

    @FXML
    private Tab cadastrarUsuario;

    @FXML
    private Tab visualizarIdoso;

    @FXML
    private TabPane principal;

    @FXML
    void trocarPainel(KeyEvent event) { // Troca de abas de acordo com a tecla clicada
        switch (event.getCode()) {
            case F1:
                principal.getSelectionModel().select(visualizarIdoso);
                break;
            
            case F2:
                principal.getSelectionModel().select(cadastrarUsuario);
                break;
            
            case F3:
                principal.getSelectionModel().select(cadastrarIdoso);
                break;

            case F4:
                principal.getSelectionModel().select(cadastrarRemedio);
                break;

            case F5:
                principal.getSelectionModel().select(cadastrarRemedioIdoso);
                break;

            default:
                break;
        }
    }

    @FXML
    void initialize() {

    }

}
