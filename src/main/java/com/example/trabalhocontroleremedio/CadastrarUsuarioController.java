package com.example.trabalhocontroleremedio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class CadastrarUsuarioController {

    //private Usuario user;
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
    void cadastrar(ActionEvent event) { // Cadastra usuário no banco
        //this.user = new Usuario();
        int matricula;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou usuário com matrícula: " + this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }

        //this.user.adicionarUsuario(this.login.getText(), this.senha.getText(), this.tipo.getValue(), this.nome.getText(), this.telefone.getText(), matricula);
    }

    @FXML
    void buscar(ActionEvent event) { // Busca usuário no banco
        /*this.login.setText(this.user.getLogin());
        this.tipo.setValue(this.user.getTipo());
        this.nome.setText(this.user.getNome());
        this.telefone.setText(this.user.getTelefone());
        this.matricula.setText(Integer.toString(this.user.getMatricula()));*/
    }

    @FXML
    void alterar(ActionEvent event) { // Altera usuário no banco
        int matricula;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
            HelloApplication.escreverLog(Login.getLogin() + " alterou usuário com matrícula: " + this.matricula.getText());
            //this.user.alterarUsuario(this.login.getText(), this.senha.getText(), this.tipo.getValue(), this.nome.getText(), this.telefone.getText(), matricula);
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }
    }

    @FXML
    void excluir(ActionEvent event) { // Exclui um usuário no banco
        int matricula;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
            //this.user.excluirUsuario();
            HelloApplication.escreverLog(Login.getLogin() + " excluiu usuário com matrícula: " + this.matricula.getText());
            this.login.setText(null);
            this.tipo.setValue("Usuário");
            this.nome.setText(null);
            this.telefone.setText(null);
            this.matricula.setText(null);
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }
    }

    @FXML
    void initialize() {
        listaTipo = FXCollections.observableArrayList("Usuário", "Administrador");
        tipo.setItems(listaTipo);
        tipo.setValue("Usuário");
    }

}
