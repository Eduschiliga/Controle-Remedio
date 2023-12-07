package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.trabalhocontroleremedio.banco.RemedioDAO;
import com.example.trabalhocontroleremedio.enumeracao.Dosagem;
import com.example.trabalhocontroleremedio.excecao.CampoVazioExcecao;
import com.example.trabalhocontroleremedio.modelo.Login;
import com.example.trabalhocontroleremedio.modelo.Remedio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CadastrarRemedioController {

    private Remedio remedio;
    private ObservableList<String> listaDosagem;
    private RemedioDAO jpa;

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
    private ChoiceBox<String> formaDosagem;

    @FXML
    private TextField nome;

    @FXML
    private TextField nomeGenerico;

    @FXML
    private Label excecao;

    @FXML
    void alterar(ActionEvent event) { // Faz a alteração dos dados do remédio no banco
        excecao.setVisible(false);
        excecao.textFillProperty().set(Color.RED);
        try {
            if(nome.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            remedio.setCategoria(categoria.getText());
            remedio.setFormaDosagem(formaDosagem.getValue());
            remedio.setNome(nome.getText());
            remedio.setNomeGenerico(nomeGenerico.getText());
            jpa.editar(remedio);
            excecao.setText("Remédio alterado com sucesso!");
            excecao.textFillProperty().set(Color.GREEN);
            excecao.setVisible(true);
            HelloApplication.escreverLog(Login.getLogin() + " alterou " + this.nome.getText());
        } catch (NumberFormatException NFE) {
            System.out.println("A mátricula deve conter apenas números");
            excecao.setText("Necessário ter apenas números na mátricula!");
            excecao.setVisible(true);
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer um nome!");
            excecao.setText("Necessário fornecer um nome!");
            excecao.setVisible(true);
        }catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @FXML
    void buscar(ActionEvent event) { // Busca um remédio no banco
        excecao.setVisible(false);
        excecao.textFillProperty().set(Color.RED);
        try{
            if(nome.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            remedio = new Remedio();
            remedio.setNome(nome.getText());
            remedio = jpa.buscarNome(remedio);
            if(remedio != null){
                nomeGenerico.setText(remedio.getNomeGenerico());
                categoria.setText(remedio.getCategoria());
                formaDosagem.setValue(remedio.getFormaDosagem());
            }else{
                excecao.setText("Remédio não encontrado!");
                excecao.setVisible(true);
            }
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer um nome!");
            excecao.setText("Necessário fornecer um nome!");
            excecao.setVisible(true);
        }catch(NullPointerException NPE){
            System.out.println(NPE);
        }
    }

    @FXML
    void cadastrar(ActionEvent event) { // Cadastra o remédio no banco
        excecao.setVisible(false);
        excecao.textFillProperty().set(Color.RED);
        try {
            if(nome.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            remedio = new Remedio();
            int totalRemedio = 0;
            for(Remedio remedio : jpa.buscarTodos()){
                if(remedio != null){
                    totalRemedio = remedio.getIdRemedio();
                }
            }
            remedio.setIdRemedio(totalRemedio + 1);
            remedio.setCategoria(categoria.getText());
            remedio.setNome(nome.getText());
            remedio.setNomeGenerico(nomeGenerico.getText());
            remedio.setFormaDosagem(formaDosagem.getValue());
            jpa.cadastrar(remedio);
            excecao.setText("Remédio cadastrado com sucesso!");
            excecao.textFillProperty().set(Color.GREEN);
            excecao.setVisible(true);
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou " + this.nome.getText());
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer um nome para o remédio");
            excecao.setText("Necessário fornecer um nome!");
            excecao.setVisible(true);
        }catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @FXML
    void excluir(ActionEvent event) { // Exclui um remédio do banco
        excecao.setVisible(false);
        excecao.textFillProperty().set(Color.RED);
        try{
            if(nome.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            remedio = new Remedio();
            remedio.setNome(nome.getText());
            remedio = jpa.buscarNome(remedio);
            jpa.excluir(remedio);
            this.nome.setText("");
            this.nomeGenerico.setText("");
            this.categoria.setText("");
            excecao.setText("Remédio excluido com sucesso!");
            excecao.textFillProperty().set(Color.GREEN);
            excecao.setVisible(true);
            HelloApplication.escreverLog(Login.getLogin() + " excluiu " + this.nome.getText());
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer um nome!");
            excecao.setText("Necessário fornecer um nome!");
            excecao.setVisible(true);
        }catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @FXML
    void initialize() {
        listaDosagem = FXCollections.observableArrayList();
        for(Dosagem listaDosagem: Dosagem.values()){
            this.listaDosagem.add(listaDosagem.getDosagem());
        }
        formaDosagem.setItems(listaDosagem);
        formaDosagem.setValue("Miligrama");
        jpa = new RemedioDAO();
    }
}
