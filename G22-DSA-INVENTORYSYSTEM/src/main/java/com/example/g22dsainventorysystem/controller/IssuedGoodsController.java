package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import com.example.g22dsainventorysystem.structures.TestConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IssuedGoodsController {

    @FXML
    private Button btnCancel;
    @FXML
    private TextArea salesProductName,salesProductQuantity,totalPrice;
    @FXML
    private TextField saleVendorName;

    @FXML
    private DatePicker datePicker;



    @FXML
    private Button btnUpdateCancel;

    Connection connection = TestConnection.ConnectionUtil.connectdb();
    public void insertInto(javafx.event.ActionEvent activeEvent){
        String stateMent = "INSERT INTO `IssuedGoods`(`Quantity`, `Product_ID`, `Selling_Price`, `TotalAmount`, `Date`)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(stateMent);
            ps.setString(1, String.valueOf(salesProductQuantity.getText()));
            ps.setString(2,String.valueOf(salesProductName.getText()));
            ps.setString(3,String.valueOf(totalPrice.getText()));
            ps.setString(4,String.valueOf( Integer.parseInt(salesProductQuantity.getText()) * Double.parseDouble(totalPrice.getText())));
            ps.setString(5,String.valueOf(datePicker.getValue()));



            ps.executeUpdate();
            refreshed();
            search_user();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void search_user() {
    }

    public void refreshed() {
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

    public void updateClose(ActionEvent event) {
        Stage stage = (Stage) btnUpdateCancel.getScene().getWindow();
        stage.close();
    }


    public void updateIssueGoods(ActionEvent event) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/IssuedGoods/UpdateIssueGoods.fxml");
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

    public void savedUpdatedGoods(ActionEvent event) {

    }
}
