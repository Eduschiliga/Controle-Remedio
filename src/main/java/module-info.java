module com.example.trabalhocontroleremedio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabalhocontroleremedio to javafx.fxml;
    exports com.example.trabalhocontroleremedio;
}