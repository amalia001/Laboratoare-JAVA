module com.example.laboratorul_6_compulsory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laboratorul_6_compulsory to javafx.fxml;
    exports com.example.laboratorul_6_compulsory;
}