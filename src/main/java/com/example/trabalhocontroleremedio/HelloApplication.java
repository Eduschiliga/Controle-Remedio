package com.example.trabalhocontroleremedio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

//import com.example.trabalhocontroleremedio.arquivo.GravarTexto;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene principal;
    private static Scene login;
    //private static GravarTexto log;

    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Controle de Remédios");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        login = new Scene(fxmlLogin);

        Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        principal = new Scene(fxmlPrincipal);

        primaryStage.setScene(login);
        primaryStage.show();
    }

    public static void trocarTela(String tela){ // Realiza a troca de tela de acordo com a informada no controller
        switch (tela) {
            case "Principal":
                stage.setScene(principal);
                break;
        
            case "Login":
                stage.setScene(login);
                break;
        }
    }

    public static void escreverLog(String texto){
        //log.inserirTexto(texto);
    }

    public static void main(String[] args) {
        //Inicia o programa
        //log = new GravarTexto("Log.txt");
        launch();
    }
}