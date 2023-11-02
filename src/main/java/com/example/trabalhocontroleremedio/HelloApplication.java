package com.example.trabalhocontroleremedio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;

    private static Scene principal;
    private static Scene login;
    private static Scene cadastrarRemedio;
    private static Scene cadastrarUsuario;
    private static Scene cadastrarRemedioIdoso;

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Controle de Remédios");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        login = new Scene(fxmlLogin);

        Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        principal = new Scene(fxmlPrincipal);

        /*Parent fxmlCadastrarRemedio = FXMLLoader.load(getClass().getResource("CadastrarRemedio.fxml"));
        cadastrarRemedio = new Scene(fxmlCadastrarRemedio);

        Parent fxmlCadastrarUsuario = FXMLLoader.load(getClass().getResource("CadastrarUsuario.fxml"));
        cadastrarUsuario = new Scene(fxmlCadastrarUsuario);

        Parent fxmlCadastrarRemedioIdoso = FXMLLoader.load(getClass().getResource("CadastrarRemdioIdoso.fxml"));
        cadastrarRemedioIdoso = new Scene(fxmlCadastrarRemedioIdoso);*/

        primaryStage.setScene(principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //Inicia o programa
        launch();
    }
}