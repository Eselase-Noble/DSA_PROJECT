module com.example.g22dsainventorysystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.g22dsainventorysystem to javafx.fxml;
    exports com.example.g22dsainventorysystem;
}