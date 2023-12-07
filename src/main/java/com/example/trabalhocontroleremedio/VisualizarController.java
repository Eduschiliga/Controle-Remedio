package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.example.trabalhocontroleremedio.banco.RemedioIdosoDAO;
import com.example.trabalhocontroleremedio.modelo.Horario;
import com.example.trabalhocontroleremedio.modelo.HorarioRemedio;
import com.example.trabalhocontroleremedio.modelo.Remedio;
import com.example.trabalhocontroleremedio.modelo.RemedioIdoso;

public class VisualizarController {

    private RemedioIdoso remedioIdoso;
    private Horario horarioM;
    private RemedioIdosoDAO jpa;
    private ObservableList<HorarioRemedio> lista;
    private String[] listaHorario;
    private String[] listaDias;
    private HorarioRemedio horarioRemedio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<HorarioRemedio, String> domingo;

    @FXML
    private TableColumn<HorarioRemedio, String> horario;

    @FXML
    private TableColumn<HorarioRemedio, String> quarta;

    @FXML
    private TableColumn<HorarioRemedio, String> quinta;

    @FXML
    private TableColumn<HorarioRemedio, String> sabado;

    @FXML
    private TableColumn<HorarioRemedio, String> segunda;

    @FXML
    private TableColumn<HorarioRemedio, String> sexta;

    @FXML
    private TableColumn<HorarioRemedio, String> terca;

    @FXML
    private TableView<HorarioRemedio> tabela;

    @FXML
    private TextField nome;

    @FXML
    void buscar(ActionEvent event) {
        remedioIdoso = jpa.buscarRemedioIdosoNome(nome.getText());
        verficarHorarios();
        verifcarDias();
        lista = FXCollections.observableArrayList();
        for(int i = 0;i<24;i++){
            if(listaHorario[i] != ""){
                lista.add(new HorarioRemedio(listaHorario[i],listaDias[0],listaDias[1],listaDias[2],listaDias[3],listaDias[4],listaDias[5],listaDias[6]));
            }
        }
        montarTabela();
    }

    private void verficarHorarios(){
        listaHorario = new String[24];
        listaHorario[0] = (remedioIdoso.getFkHorario().getH1()) ? "01:00" : "";
        listaHorario[1] = (remedioIdoso.getFkHorario().getH2()) ? "02:00" : "";
        listaHorario[2] = (remedioIdoso.getFkHorario().getH3()) ? "03:00" : "";
        listaHorario[3] = (remedioIdoso.getFkHorario().getH4()) ? "04:00" : "";
        listaHorario[4] = (remedioIdoso.getFkHorario().getH5()) ? "05:00" : "";
        listaHorario[5] = (remedioIdoso.getFkHorario().getH6()) ? "06:00" : "";
        listaHorario[6] = (remedioIdoso.getFkHorario().getH7()) ? "07:00" : "";
        listaHorario[7] = (remedioIdoso.getFkHorario().getH8()) ? "08:00" : "";
        listaHorario[8] = (remedioIdoso.getFkHorario().getH9()) ? "09:00" : "";
        listaHorario[9] = (remedioIdoso.getFkHorario().getH10()) ? "10:00" : "";
        listaHorario[10] = (remedioIdoso.getFkHorario().getH11()) ? "11:00" : "";
        listaHorario[11] = (remedioIdoso.getFkHorario().getH12()) ? "12:00" : "";
        listaHorario[12] = (remedioIdoso.getFkHorario().getH13()) ? "13:00" : "";
        listaHorario[13] = (remedioIdoso.getFkHorario().getH14()) ? "14:00" : "";
        listaHorario[14] = (remedioIdoso.getFkHorario().getH15()) ? "15:00" : "";
        listaHorario[15] = (remedioIdoso.getFkHorario().getH16()) ? "16:00" : "";
        listaHorario[16] = (remedioIdoso.getFkHorario().getH17()) ? "17:00" : "";
        listaHorario[17] = (remedioIdoso.getFkHorario().getH18()) ? "18:00" : "";
        listaHorario[18] = (remedioIdoso.getFkHorario().getH19()) ? "19:00" : "";
        listaHorario[19] = (remedioIdoso.getFkHorario().getH20()) ? "20:00" : "";
        listaHorario[20] = (remedioIdoso.getFkHorario().getH21()) ? "21:00" : "";
        listaHorario[21] = (remedioIdoso.getFkHorario().getH22()) ? "22:00" : "";
        listaHorario[22] = (remedioIdoso.getFkHorario().getH23()) ? "23:00" : "";
        listaHorario[23] = (remedioIdoso.getFkHorario().getH24()) ? "24:00" : "";
    }

    private void verifcarDias(){
        listaDias = new String[7];
        for(int i = 0;i<7;i++){
            if(remedioIdoso.getQuantidadeDias() > i){
                listaDias[i] = remedioIdoso.getFkRemedio().getNome();
            }else{
                listaDias[i] = "";
            }
        }
    }

    private void montarTabela(){
        tabela.setItems(lista);
        horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
        segunda.setCellValueFactory(new PropertyValueFactory<>("segunda"));
        terca.setCellValueFactory(new PropertyValueFactory<>("terca"));
        quarta.setCellValueFactory(new PropertyValueFactory<>("quarta"));
        quinta.setCellValueFactory(new PropertyValueFactory<>("quinta"));
        sexta.setCellValueFactory(new PropertyValueFactory<>("sexta"));
        sabado.setCellValueFactory(new PropertyValueFactory<>("sabado"));
        domingo.setCellValueFactory(new PropertyValueFactory<>("domingo"));
    }

    @FXML
    void initialize() {
        jpa = new RemedioIdosoDAO();
    }
}
