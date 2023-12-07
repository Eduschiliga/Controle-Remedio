package com.example.trabalhocontroleremedio;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Monica
 */
public class CaixaDialogo<T> {

    public static void displayMensagem(String tipo, String mensagem) {
        Alert.AlertType alertTipo = Alert.AlertType.valueOf(tipo);
        String titulo = new String();
        String cabecalho = new String();

        switch (alertTipo) {
            case CONFIRMATION:
                titulo = "Confirmação";
                cabecalho = "Confirme sua opção:";
                break;
            case ERROR:
                titulo = "Mensagem de Erro";
                cabecalho = "Foi detectado um erro!";
                break;
            case WARNING:
                titulo = "Advertência do Sistema";
                cabecalho = "A ação não é muito aconselhada!";
                break;
            default:
                titulo = "Informação";
                cabecalho = "";
        }
        Alert dialogoInfo = new Alert(alertTipo);
        dialogoInfo.setTitle(titulo);
        dialogoInfo.setHeaderText(cabecalho);
        dialogoInfo.setContentText(mensagem);
        dialogoInfo.showAndWait();
    }

    public static void displayMensagem(String tipo, String mensagem, String cabecalho) {
        Alert.AlertType alertTipo = Alert.AlertType.valueOf(tipo);
        String titulo = new String();
        switch (alertTipo) {
            case CONFIRMATION:
                titulo = "Confirmação";
                break;
            case ERROR:
                titulo = "Mensagem de Erro";
                break;
            case WARNING:
                titulo = "Advertência do Sistema";
                break;
            default:
                titulo = "Informação";
        }
        Alert dialogoInfo = new Alert(alertTipo);
        dialogoInfo.setTitle(titulo);
        dialogoInfo.setHeaderText(cabecalho);
        dialogoInfo.setContentText(mensagem);
        dialogoInfo.showAndWait();
    }

    public static ButtonType displayConfirmacao(String tipo, String mensagem, String cabecalho) {
        Alert.AlertType alertTipo = Alert.AlertType.valueOf(tipo);
        Alert dialogoInfo = new Alert(alertTipo);
        dialogoInfo.setTitle("Tela de Confirmação");
        dialogoInfo.setHeaderText(cabecalho);
        dialogoInfo.setContentText(mensagem);

        Optional<ButtonType> option = dialogoInfo.showAndWait();
        return option.get();
    }

    public static String displayEntrada(String tituloJanela, String mensagem, String cabecalho) {
        TextInputDialog dialogoNome = new TextInputDialog();

        dialogoNome.setTitle(tituloJanela);
        dialogoNome.setHeaderText(cabecalho);
        dialogoNome.setContentText(mensagem);
        // se o usuário fornecer um valor, assignamos ao nome
        return dialogoNome.showAndWait().toString();
    }

    public static String displayOptions(String tituloJanela, String mensagem, String cabecalho, ArrayList<String> opcoes) {
        ChoiceDialog<String> dialogoOpcao = new ChoiceDialog(opcoes.get(0), opcoes);
        String retorno = new String();
        dialogoOpcao.setTitle(tituloJanela);
        dialogoOpcao.setHeaderText(cabecalho);
        dialogoOpcao.setContentText(mensagem);
        // se o usuário fornecer um valor, assignamos ao nome
        return dialogoOpcao.showAndWait().toString(); //.ifPresent(r -> retorno = r.toString();
//        return retorno;
    }
    public T displayOptions(String tituloJanela, String mensagem, String cabecalho, ArrayList<T> opcoes, boolean tipo) {
        ChoiceDialog<T> dialogoOpcao = new ChoiceDialog(opcoes.get(0), opcoes);
        
        dialogoOpcao.setTitle(tituloJanela);
        dialogoOpcao.setHeaderText(cabecalho);
        dialogoOpcao.setContentText(mensagem);
        // se o usuário fornecer um valor, assignamos ao nome
        Optional<T> option = dialogoOpcao.showAndWait(); 
        return option.get(); //.ifPresent(r -> retorno = r.toString();
//        return retorno;
    }

}
