module com.example.g22dsainventorysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires java.desktop;


    opens com.example.g22dsainventorysystem to javafx.fxml;
    opens com.example.g22dsainventorysystem.controller to javafx.fxml;
    opens com.example.g22dsainventorysystem.structures to javafx.fxml, javafx.base;
    opens com.example.g22dsainventorysystem.models to javafx.base;
    //opens application.login to javafx.fxml;
    exports com.example.g22dsainventorysystem;
}