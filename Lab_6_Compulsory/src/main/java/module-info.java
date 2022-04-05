module com.example.lab_6_compulsory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_6_compulsory to javafx.fxml;
    exports com.example.lab_6_compulsory;
}