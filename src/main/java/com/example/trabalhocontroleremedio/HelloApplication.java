package com.example.trabalhocontroleremedio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CadastrarUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Controle de Remédios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //Inicia o programa
        launch();
    }
}