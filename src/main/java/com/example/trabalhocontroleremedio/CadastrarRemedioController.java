package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CadastrarRemedioController {

    private Remedio remedio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdicionarImagem;

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
    private ImageView image;

    @FXML
    private TextField nome;

    @FXML
    private TextField nomeGenerico;

    @FXML
    void adicionarImagem(ActionEvent event) {

    }

    @FXML
    void alterar(ActionEvent event) {
        int dosagem = 0;
        try {
            dosagem = Integer.parseInt(this.dosagem.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }

        this.remedio.alterarRemedio(this.nome.getText(), this.nomeGenerico.getText(), this.categoria.getText(), dosagem, this.formaDosagem.getText());
    }

    @FXML
    void buscar(ActionEvent event) {
        this.nome.setText(this.remedio.getNome());
        this.nomeGenerico.setText(this.remedio.getNomeGenerico());
        this.categoria.setText(this.remedio.getCategoria());
        this.dosagem.setText(Integer.toString(this.remedio.getDosagem()));
        this.formaDosagem.setText(this.remedio.getFormaDosagem());
    }

    @FXML
    void cadastrar(ActionEvent event) {
        this.remedio = new Remedio();

        int dosagem = 0;
        try {
            dosagem = Integer.parseInt(this.dosagem.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
        }

        this.remedio.alterarRemedio(this.nome.getText(), this.nomeGenerico.getText(), this.categoria.getText(), dosagem, this.formaDosagem.getText());
    }

    @FXML
    void excluir(ActionEvent event) {
        this.remedio.excluirRemedio();
       this.nome.setText(null);
        this.nomeGenerico.setText(null);
        this.categoria.setText(null);
        this.dosagem.setText(null);
        this.formaDosagem.setText(null);
    }

    @FXML
    void initialize() {
        assert btnAdicionarImagem != null : "fx:id=\"btnAdicionarImagem\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert btnAlterar != null : "fx:id=\"btnAlterar\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert btnExcluir != null : "fx:id=\"btnExcluir\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert categoria != null : "fx:id=\"categoria\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert dosagem != null : "fx:id=\"dosagem\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert formaDosagem != null : "fx:id=\"formaDosagem\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";
        assert nomeGenerico != null : "fx:id=\"nomeGenerico\" was not injected: check your FXML file 'CadastrarRemedio.fxml'.";

    }

}
