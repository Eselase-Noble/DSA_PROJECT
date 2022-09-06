package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class LoginController {

        @FXML
        private Stage stage;

        @FXML
        private Parent root;

        @FXML
        private Scene scene;

        @FXML
        private AnchorPane apDesignPane;

        @FXML
        private AnchorPane apMother;

        @FXML
        private Button btnPassFieldClear;

        @FXML
        private Button btnUserNameTfClear;

        @FXML
        private Button loginbutton;

        @FXML
        private PasswordField password;

        @FXML
        private TextField username;


    @FXML
    public void loginBtnActionNew(ActionEvent event) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/Dashboard/Dashboard.fxml");
        FXMLLoader newlogin = new FXMLLoader(fxmlLocation);
        try {
            newlogin.load();
            Parent parent = newlogin.getRoot();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            System.out.println("i am working");
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
