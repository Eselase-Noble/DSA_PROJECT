package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class BillsController {
    @FXML
    private Button btnaddBill;

    @FXML
    private Button btnCancel;
    @FXML
    void openAddBill(ActionEvent event) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/Bills/AddBill.fxml");
        FXMLLoader loader3 = new FXMLLoader(fxmlLocation);
        try {
            loader3.load();
            Parent parent = loader3.getRoot();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void refreshed(ActionEvent event) {

    }
    @FXML
    void addBill(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void search_user(ActionEvent actionEvent) {
    }

    public void getSelected(MouseEvent mouseEvent) {
    }

    public void Delete(ActionEvent actionEvent) {
    }
}
