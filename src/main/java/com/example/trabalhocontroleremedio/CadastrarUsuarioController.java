package com.example.trabalhocontroleremedio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class CadastrarUsuarioController {

    private Usuario user;
    private ObservableList<String> listaTipo;

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
    private ChoiceBox<String> tipo;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnExcluir;

    @FXML
    void cadastrar(ActionEvent event) {
        this.user = new Usuario();
        int matricula = 0;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }

        this.user.adicionarUsuario(this.login.getText(), this.senha.getText(), this.tipo.getValue(), this.nome.getText(), this.telefone.getText(), matricula);
    }

    @FXML
    void buscar(ActionEvent event) {
        this.login.setText(this.user.getLogin());
        this.tipo.setValue(this.user.getTipo());
        this.nome.setText(this.user.getNome());
        this.telefone.setText(this.user.getTelefone());
        this.matricula.setText(Integer.toString(this.user.getMatricula()));
    }

    @FXML
    void alterar(ActionEvent event) {
        int matricula = 0;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }

        this.user.alterarUsuario(this.login.getText(), this.senha.getText(), this.tipo.getValue(), this.nome.getText(), this.telefone.getText(), matricula);
    }

    @FXML
    void excluir(ActionEvent event) {
        this.user.excluirUsuario();
        this.login.setText(null);
        this.tipo.setValue("Usuário");
        this.nome.setText(null);
        this.telefone.setText(null);
        this.matricula.setText(null);
    }

    @FXML
    void telaPrincipal(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE){
            HelloApplication.trocarTela("Principal");
        }
    }

    @FXML
    void initialize() {
        listaTipo = FXCollections.observableArrayList("Usuário", "Administrador");
        tipo.setItems(listaTipo);
        tipo.setValue("Usuário");
    }

}
