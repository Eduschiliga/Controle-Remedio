module com.example.trabalhocontroleremedio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.controleRemedio.application to javafx.fxml;
    exports com.controleRemedio.application;
}