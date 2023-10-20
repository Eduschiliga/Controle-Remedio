package com.example.trabalhocontroleremedio;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("CadastrarRemedioIdoso.fxml"));
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