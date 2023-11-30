package com.example.trabalhocontroleremedio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import com.example.trabalhocontroleremedio.banco.UsuarioDAO;
import com.example.trabalhocontroleremedio.excecao.CampoVazioExcecao;
import com.example.trabalhocontroleremedio.modelo.Login;
import com.example.trabalhocontroleremedio.modelo.Usuario;

import javafx.collections.FXCollections;

public class CadastrarUsuarioController {

    private Usuario usuario;
    private UsuarioDAO jpa;
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
        int matricula;
        try {
            matricula = Integer.parseInt(this.matricula.getText());
            usuario.setLogin(this.login.getText());
            usuario.setNome(this.nome.getText());
            usuario.setSenha(this.senha.getText());
            usuario.setMatricula(matricula);
            usuario.setTelefone(this.telefone.getText());
            usuario.setTipo(this.tipo.getValue());
            //jpa.cadastrar(usuario);
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou usuário com matrícula: " + this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    void buscar(ActionEvent event) { // Busca usuário no banco
        try{
            if(matricula.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            usuario.setMatricula(Integer.parseInt(this.matricula.getText()));
            //usuario = jpa.buscar(usuario);
            if(usuario != null){
                nome.setText(usuario.getNome());
                login.setText(usuario.getLogin());
                tipo.setValue(usuario.getTipo());
                telefone.setText(usuario.getTelefone());
            }
        }catch(CampoVazioExcecao CVE){
            System.out.println("Campo matrícula vazio!");
        }catch(NumberFormatException NFE){
            System.out.println("Necessário utilizar apenas números na matricula!");
        }
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
        usuario = new Usuario();
        jpa = new UsuarioDAO();
    }

}
