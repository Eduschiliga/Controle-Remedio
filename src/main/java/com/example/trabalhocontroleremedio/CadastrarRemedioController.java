package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastrarRemedioController {

    private Remedio remedio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField categoria;

    @FXML
    private TextField dosagem;

    @FXML
    private TextField formaDosagem;

    @FXML
    private TextField nome;

    @FXML
    private TextField nomeGenerico;

    @FXML
    void alterar(ActionEvent event) { // Faz a alteração dos dados do remédio no banco
        int dosagem;
        try {
            dosagem = Integer.parseInt(this.dosagem.getText());
            this.remedio.alterarRemedio(this.nome.getText(), this.nomeGenerico.getText(), this.categoria.getText(), dosagem, this.formaDosagem.getText());
            HelloApplication.escreverLog(Login.getLogin() + " alterou " + this.nome.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }
    }

    @FXML
    void buscar(ActionEvent event) { // Busca um remédio no banco
        this.nome.setText(this.remedio.getNome());
        this.nomeGenerico.setText(this.remedio.getNomeGenerico());
        this.categoria.setText(this.remedio.getCategoria());
        this.dosagem.setText(Integer.toString(this.remedio.getDosagem()));
        this.formaDosagem.setText(this.remedio.getFormaDosagem());
    }

    @FXML
    void cadastrar(ActionEvent event) { // Cadastra o remédio no banco
        this.remedio = new Remedio();
        int dosagem;
        try {
            dosagem = Integer.parseInt(this.dosagem.getText());
            this.remedio.alterarRemedio(this.nome.getText(), this.nomeGenerico.getText(), this.categoria.getText(), dosagem, this.formaDosagem.getText());
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou " + this.nome.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }
    }

    @FXML
    void excluir(ActionEvent event) { // Exclui um remédio do banco
        this.remedio.excluirRemedio();
        this.nome.setText(null);
        this.nomeGenerico.setText(null);
        this.categoria.setText(null);
        this.dosagem.setText(null);
        this.formaDosagem.setText(null);
        HelloApplication.escreverLog(Login.getLogin() + " excluiu " + this.nome.getText());
    }

    @FXML
    void initialize() {

    }

}
