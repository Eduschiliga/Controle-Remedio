package com.example.trabalhocontroleremedio;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.trabalhocontroleremedio.banco.HorarioDAO;
import com.example.trabalhocontroleremedio.banco.IdosoDAO;
import com.example.trabalhocontroleremedio.banco.RemedioDAO;
import com.example.trabalhocontroleremedio.banco.RemedioIdosoDAO;
import com.example.trabalhocontroleremedio.excecao.CampoVazioExcecao;
import com.example.trabalhocontroleremedio.modelo.Horario;
import com.example.trabalhocontroleremedio.modelo.Idoso;
import com.example.trabalhocontroleremedio.modelo.Login;
import com.example.trabalhocontroleremedio.modelo.Remedio;
import com.example.trabalhocontroleremedio.modelo.RemedioIdoso;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CadastrarRemedioIdosoController {

    private Idoso idosoM;
    private Remedio remedioM;
    private Horario horarioM;
    private RemedioIdoso remedioIdosoM;
    private IdosoDAO jpaIdoso;
    private RemedioDAO jpaRemedio;
    private HorarioDAO jpaHorario;
    private RemedioIdosoDAO jpaRemedioIdoso;

    @FXML
    private Button buscar;

    @FXML
    private Button cadastrar;

    @FXML
    private TextField dias;

    @FXML
    private TextField dosagem;

    @FXML
    private Button editar;

    @FXML
    private Button excluir;

    @FXML
    private TextField idoso;

    @FXML
    private TextField remedio;

    @FXML
    private CheckBox h1;

    @FXML
    private CheckBox h10;

    @FXML
    private CheckBox h11;

    @FXML
    private CheckBox h12;

    @FXML
    private CheckBox h13;

    @FXML
    private CheckBox h14;

    @FXML
    private CheckBox h15;

    @FXML
    private CheckBox h16;

    @FXML
    private CheckBox h17;

    @FXML
    private CheckBox h18;

    @FXML
    private CheckBox h19;

    @FXML
    private CheckBox h2;

    @FXML
    private CheckBox h20;

    @FXML
    private CheckBox h21;

    @FXML
    private CheckBox h22;

    @FXML
    private CheckBox h23;

    @FXML
    private CheckBox h24;

    @FXML
    private CheckBox h3;

    @FXML
    private CheckBox h4;

    @FXML
    private CheckBox h5;

    @FXML
    private CheckBox h6;

    @FXML
    private CheckBox h7;

    @FXML
    private CheckBox h8;

    @FXML
    private CheckBox h9;

    @FXML
    void buscar(ActionEvent event) {
        try{
            if(idoso.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            idosoM = new Idoso();
            remedioIdosoM = new RemedioIdoso();
            idosoM.setNome(idoso.getText());
            idosoM = jpaIdoso.buscarNome(idosoM);
            if(idosoM != null){
                remedioIdosoM = jpaRemedioIdoso.buscarRemedioIdosoNome(idosoM.getNome());
                remedio.setText(remedioIdosoM.getFkRemedio().getNome());
                dosagem.setText(remedioIdosoM.getDosagem().toString());
                dias.setText(remedioIdosoM.getQuantidadeDias().toString());
                h1.setSelected(remedioIdosoM.getFkHorario().getH1());
                h2.setSelected(remedioIdosoM.getFkHorario().getH2());
                h3.setSelected(remedioIdosoM.getFkHorario().getH3());
                h4.setSelected(remedioIdosoM.getFkHorario().getH4());
                h5.setSelected(remedioIdosoM.getFkHorario().getH5());
                h6.setSelected(remedioIdosoM.getFkHorario().getH6());
                h7.setSelected(remedioIdosoM.getFkHorario().getH7());
                h8.setSelected(remedioIdosoM.getFkHorario().getH8());
                h9.setSelected(remedioIdosoM.getFkHorario().getH9());
                h10.setSelected(remedioIdosoM.getFkHorario().getH10());
                h11.setSelected(remedioIdosoM.getFkHorario().getH11());
                h12.setSelected(remedioIdosoM.getFkHorario().getH12());
                h13.setSelected(remedioIdosoM.getFkHorario().getH13());
                h14.setSelected(remedioIdosoM.getFkHorario().getH14());
                h15.setSelected(remedioIdosoM.getFkHorario().getH15());
                h16.setSelected(remedioIdosoM.getFkHorario().getH16());
                h17.setSelected(remedioIdosoM.getFkHorario().getH17());
                h18.setSelected(remedioIdosoM.getFkHorario().getH18());
                h19.setSelected(remedioIdosoM.getFkHorario().getH19());
                h20.setSelected(remedioIdosoM.getFkHorario().getH20());
                h21.setSelected(remedioIdosoM.getFkHorario().getH21());
                h22.setSelected(remedioIdosoM.getFkHorario().getH22());
                h23.setSelected(remedioIdosoM.getFkHorario().getH23());
                h24.setSelected(remedioIdosoM.getFkHorario().getH24());
            }
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer um nome!");
        }catch(NullPointerException NPE){
            System.out.println("Sem ocorrência do Idoso solicitado!");
        }
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try{
            if(idoso.getText().equals("") || remedio.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            idosoM = new Idoso();
            remedioM = new Remedio();
            horarioM = new Horario();
            remedioIdosoM = new RemedioIdoso();
            idosoM.setNome(idoso.getText());
            idosoM = jpaIdoso.buscarNome(idosoM);
            remedioM.setNome(remedio.getText());
            remedioM = jpaRemedio.buscarNome(remedioM);
            if(idosoM != null && remedioM != null){
                remedioIdosoM.setDosagem(Float.parseFloat(dosagem.getText()));
                remedioIdosoM.setFkIdoso(idosoM);
                remedioIdosoM.setFkRemedio(remedioM);
                remedioIdosoM.setQuantidadeDias(Integer.parseInt(dias.getText()));

                int totalHorario = 0;
                int totalRemedioIdoso = 0;
                for (Horario horario : jpaHorario.buscarTodos()) {
                    if(horario != null){
                        totalHorario = horario.getIdhorario();
                    }
                }
                for (RemedioIdoso remedioIdoso : jpaRemedioIdoso.buscarTodos()) {
                    if(remedioIdoso != null){
                        totalRemedioIdoso = remedioIdoso.getIdRemedioIdoso();
                    }
                }
                horarioM.setIdHorario(totalHorario+1);
                horarioM.setH1(h1.isSelected());
                horarioM.setH2(h2.isSelected());
                horarioM.setH3(h3.isSelected());
                horarioM.setH4(h4.isSelected());
                horarioM.setH5(h5.isSelected());
                horarioM.setH6(h6.isSelected());
                horarioM.setH7(h7.isSelected());
                horarioM.setH8(h8.isSelected());
                horarioM.setH9(h9.isSelected());
                horarioM.setH10(h10.isSelected());
                horarioM.setH11(h11.isSelected());
                horarioM.setH12(h12.isSelected());
                horarioM.setH13(h13.isSelected());
                horarioM.setH14(h14.isSelected());
                horarioM.setH15(h15.isSelected());
                horarioM.setH16(h16.isSelected());
                horarioM.setH17(h17.isSelected());
                horarioM.setH18(h18.isSelected());
                horarioM.setH19(h19.isSelected());
                horarioM.setH20(h20.isSelected());
                horarioM.setH21(h21.isSelected());
                horarioM.setH22(h22.isSelected());
                horarioM.setH23(h23.isSelected());
                horarioM.setH24(h24.isSelected());
                jpaHorario.cadastrar(horarioM);

                remedioIdosoM.setFkHorario(horarioM);
                remedioIdosoM.setIdRemedioIdoso(totalRemedioIdoso+1);
                jpaRemedioIdoso.cadastrar(remedioIdosoM);
            }
            HelloApplication.escreverLog(Login.getLogin() + " cadastrou remédio idoso");
        }catch(CampoVazioExcecao CVE){
            System.out.println("Campo Idoso ou Remédio vazios");
        }catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @FXML
    void editar(ActionEvent event) {
        try{
            if(idoso.getText().equals("") || remedio.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            idosoM = new Idoso();
            remedioM = new Remedio();
            horarioM = new Horario();
            remedioIdosoM = new RemedioIdoso();
            idosoM.setNome(idoso.getText());
            idosoM = jpaIdoso.buscarNome(idosoM);
            remedioM.setNome(remedio.getText());
            remedioM = jpaRemedio.buscarNome(remedioM);
            if(idosoM != null && remedioM != null){
                remedioIdosoM = jpaRemedioIdoso.buscarRemedioIdosoNome(idosoM.getNome());
                remedioIdosoM.setDosagem(Float.parseFloat(dosagem.getText()));
                remedioIdosoM.setFkRemedio(remedioM);
                remedioIdosoM.setQuantidadeDias(Integer.parseInt(dias.getText()));

                horarioM.setIdHorario(remedioIdosoM.getFkHorario().getIdhorario());
                horarioM.setH1(h1.isSelected());
                horarioM.setH2(h2.isSelected());
                horarioM.setH3(h3.isSelected());
                horarioM.setH4(h4.isSelected());
                horarioM.setH5(h5.isSelected());
                horarioM.setH6(h6.isSelected());
                horarioM.setH7(h7.isSelected());
                horarioM.setH8(h8.isSelected());
                horarioM.setH9(h9.isSelected());
                horarioM.setH10(h10.isSelected());
                horarioM.setH11(h11.isSelected());
                horarioM.setH12(h12.isSelected());
                horarioM.setH13(h13.isSelected());
                horarioM.setH14(h14.isSelected());
                horarioM.setH15(h15.isSelected());
                horarioM.setH16(h16.isSelected());
                horarioM.setH17(h17.isSelected());
                horarioM.setH18(h18.isSelected());
                horarioM.setH19(h19.isSelected());
                horarioM.setH20(h20.isSelected());
                horarioM.setH21(h21.isSelected());
                horarioM.setH22(h22.isSelected());
                horarioM.setH23(h23.isSelected());
                horarioM.setH24(h24.isSelected());
                jpaHorario.editar(horarioM);

                jpaRemedioIdoso.editar(remedioIdosoM);

                HelloApplication.escreverLog(Login.getLogin() + " editou remédio idoso");
            }
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer nome de Idoso e Remédio!");
        }catch(Exception Ex){
            System.out.println(Ex);
        }  
    }

    @FXML
    void excluir(ActionEvent event) {
        try{
            if(idoso.getText().equals("")){
                throw new CampoVazioExcecao();
            }
            horarioM = new Horario(remedioIdosoM.getFkHorario().getIdhorario());
            jpaRemedioIdoso.excluir(remedioIdosoM);
            jpaHorario.excluir(horarioM);
            idoso.setText("");
            dosagem.setText("");
            remedio.setText("");
            dias.setText("");
            h1.setSelected(false);
            h2.setSelected(false);
            h3.setSelected(false);
            h4.setSelected(false);
            h5.setSelected(false);
            h6.setSelected(false);
            h7.setSelected(false);
            h8.setSelected(false);
            h9.setSelected(false);
            h10.setSelected(false);
            h11.setSelected(false);
            h12.setSelected(false);
            h13.setSelected(false);
            h14.setSelected(false);
            h15.setSelected(false);
            h16.setSelected(false);
            h17.setSelected(false);
            h18.setSelected(false);
            h19.setSelected(false);
            h20.setSelected(false);
            h21.setSelected(false);
            h22.setSelected(false);
            h23.setSelected(false);
            h24.setSelected(false);
            HelloApplication.escreverLog(Login.getLogin() + " excluiu remédio idoso");
        }catch(CampoVazioExcecao CVE){
            System.out.println("Necessário fornecer nome do idoso!");
        }catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @FXML
    void initialize() {
        jpaIdoso = new IdosoDAO();
        jpaRemedio = new RemedioDAO();
        jpaHorario = new HorarioDAO();
        jpaRemedioIdoso = new RemedioIdosoDAO();
    }

}
