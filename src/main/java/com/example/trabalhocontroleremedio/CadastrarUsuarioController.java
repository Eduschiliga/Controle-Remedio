package com.example.trabalhocontroleremedio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

import com.example.trabalhocontroleremedio.banco.UsuarioDAO;
import com.example.trabalhocontroleremedio.enumeracao.Tipo;
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
    private Label excecao;

    @FXML
    void cadastrar(ActionEvent event) { // Cadastra usuário no banco
        int matricula;
        desativarExcecao();
        try {
            if(this.matricula.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            usuario = new Usuario();
            matricula = Integer.parseInt(this.matricula.getText());
            usuario.setLogin(this.login.getText());
            usuario.setNome(this.nome.getText());
            usuario.setSenha(this.senha.getText());
            usuario.setMatricula(matricula);
            usuario.setTelefone(this.telefone.getText());
            usuario.setTipo(this.tipo.getValue());
            jpa.cadastrar(usuario);
            novaExcecao("Usuário cadastrado com sucesso!", Color.GREEN);
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou usuário com matrícula: " + this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
            novaExcecao("A mátricula deve conter apenas números!", Color.RED);
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer uma mátricula");
            novaExcecao("Necessário fornecer uma mátricula!", Color.RED);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    void buscar(ActionEvent event) { // Busca usuário no banco
        desativarExcecao();
        try{
            if(matricula.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            usuario = new Usuario();
            usuario.setMatricula(Integer.parseInt(this.matricula.getText()));
            usuario = jpa.buscar(usuario);
            if(usuario != null){
                nome.setText(usuario.getNome());
                login.setText(usuario.getLogin());
                tipo.setValue(usuario.getTipo());
                telefone.setText(usuario.getTelefone());
            }
        }catch(CampoVazioExcecao CVE){
            System.out.println("Campo matrícula vazio!");
            novaExcecao("Necessário fornecer uma mátricula!", Color.RED);
        }catch(NumberFormatException NFE){
            System.out.println("Necessário utilizar apenas números na matricula!");
            novaExcecao("A mátricula deve conter apenas números!", Color.RED);
        }catch(NullPointerException NPE){
            usuario = new Usuario();
        }
    }

    @FXML
    void alterar(ActionEvent event) { // Altera usuário no banco
        desativarExcecao();
        try {
            if(matricula.getText().equals("") || senha.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            usuario = new Usuario();
            usuario.setMatricula(Integer.parseInt(matricula.getText()));
            usuario = jpa.buscar(usuario);
            if(usuario != null){
                usuario.setLogin(login.getText());
                usuario.setNome(nome.getText());
                usuario.setSenha(senha.getText());
                usuario.setTelefone(telefone.getText());
                usuario.setTipo(tipo.getValue());
                jpa.editar(usuario);
            }
            novaExcecao("Usuário alterado com sucesso!", Color.GREEN);
            HelloApplication.escreverLog(Login.getLogin() + " alterou usuário com matrícula: " + this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
            novaExcecao("A mátricula deve conter apenas números!", Color.RED);
        } catch(CampoVazioExcecao CVE){
            System.out.println("Campo matrícula ou senha vazio!");
            novaExcecao("Necessário fornecer uma mátricula!", Color.RED);
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    void excluir(ActionEvent event) { // Exclui um usuário no banco
        desativarExcecao();
        try {
            if(matricula.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            usuario = new Usuario();
            usuario.setMatricula(Integer.parseInt(this.matricula.getText()));
            jpa.excluir(usuario);
            this.login.setText("");
            this.tipo.setValue("Usuário");
            this.nome.setText("");
            this.telefone.setText("");
            this.matricula.setText("");
            this.senha.setText("");
            novaExcecao("Usuário excluido com sucesso!", Color.GREEN);
            HelloApplication.escreverLog(Login.getLogin() + " excluiu usuário com matrícula: " + this.matricula.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
            novaExcecao("A mátricula deve conter apenas números!", Color.RED);
        } catch(CampoVazioExcecao CVE){
            System.out.println("A matricula está vazia!");
            novaExcecao("Necessário fornecer uma mátricula!", Color.RED);
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    private void desativarExcecao(){
        excecao.setVisible(false);
        excecao.textFillProperty().set(Color.RED);
    }

    private void novaExcecao(String text, Color color){
        excecao.setText(text);
        excecao.textFillProperty().set(color);
        excecao.setVisible(true);
    }

    @FXML
    void initialize() {
        listaTipo = FXCollections.observableArrayList();
        for(Tipo listaTipo: Tipo.values()){
            this.listaTipo.add(listaTipo.getTipo());
        }
        tipo.setItems(listaTipo);
        tipo.setValue("Usuário");
        jpa = new UsuarioDAO();
    }

}
