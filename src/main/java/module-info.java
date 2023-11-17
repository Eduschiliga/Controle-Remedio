module com.example.trabalhocontroleremedio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javax.persistence;
    
    opens com.example.trabalhocontroleremedio to javafx.fxml;
    exports com.example.trabalhocontroleremedio;
}