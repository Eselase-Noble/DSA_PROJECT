package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import com.example.g22dsainventorysystem.models.IssuedGoods;
import com.example.g22dsainventorysystem.structures.TestConnection;
import com.example.g22dsainventorysystem.tracks.LetConnects;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField saleVendorName, tfSearch;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView <IssuedGoods> viewIssuedGoods;

    @FXML

    private TableColumn<IssuedGoods, Integer> viewIssuedID;

    @FXML

    private TableColumn<IssuedGoods, Integer> viewQuantity;

    @FXML

    private TableColumn<IssuedGoods, Integer> viewProductID;

    @FXML

    private TableColumn<IssuedGoods, Double> viewSellingPrice;

    @FXML

    private TableColumn<IssuedGoods, Double> viewTotalAmount;

    @FXML

    private TableColumn<IssuedGoods, DatePicker> viewDate;


    ObservableList<IssuedGoods> listMs;
    ObservableList<IssuedGoods> dataList;

    @FXML
    private Button btnUpdateCancel;

    Connection connection = TestConnection.ConnectionUtil.connectdb();
    public void insertInto(){
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
            search_Sales();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void search_Sales() {

        //col_id.setCellValueFactory(new PropertyValueFactory<Vendors,Integer>("id"));
        //viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vender_ID"));
        viewIssuedID.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Integer>("Product_Name"));
        //viewCategoryDescription.setCellValueFactory(new PropertyValueFactory<Category, String>("PhoneNumber"));


        LetConnects letConnects = new LetConnects();
        listMs = letConnects.getIssuedGoods();
        viewIssuedGoods.setItems(dataList);
        FilteredList<IssuedGoods> filteredData = new FilteredList<>( dataList, b -> true);
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(issuedGoods -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (issuedGoods.getIssued_ID() != -1) {
                    return true; // Filter matches username
                }

                else
                    return false; // Does not match.
            });
        });
        SortedList<IssuedGoods> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(viewIssuedGoods.comparatorProperty());
        viewIssuedGoods.setItems(sortedData);

    }
    public void refreshed() {
        viewIssuedID.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Integer>("Issued_ID"));
        viewQuantity.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Integer>("Quantity"));
        viewProductID.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Integer>("Product_ID"));
        viewSellingPrice.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Double>("Date"));
        viewTotalAmount.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Double>("Issued_ID"));
        viewDate.setCellValueFactory(new PropertyValueFactory<IssuedGoods, DatePicker>("Product_Name"));



        LetConnects letConnects = new LetConnects();
        listMs = letConnects.getIssuedGoods();
        viewIssuedGoods.setItems(listMs);
        //categoryTable.setUserData(listMs);
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
