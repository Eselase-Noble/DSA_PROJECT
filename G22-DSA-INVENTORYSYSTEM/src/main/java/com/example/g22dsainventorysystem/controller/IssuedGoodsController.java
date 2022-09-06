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

public class IssuedGoodsController {

    @FXML
    private Button btnCancel;
    public void search_user(ActionEvent actionEvent) {
    }

    public void refreshed(ActionEvent actionEvent) {
    }

    public void getSelected(MouseEvent mouseEvent) {
    }
    @FXML
    public void openIssuedGoodsForm(ActionEvent actionEvent) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/IssuedGoods/AddIssuedGoods.fxml");
        FXMLLoader loader5 = new FXMLLoader(fxmlLocation);
        try {
            loader5.load();
            Parent parent = loader5.getRoot();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void addIssuedGoods(ActionEvent actionEvent) {
    }
}
