package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.structures.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProductController {

@FXML
private TextField productNameText,productQuantityText,sellingPriceText,costPriceText, productIDTextField;

@FXML
private TableView<Product> viewProducts ;

@FXML
private TableColumn<Product, Integer> productID;
@FXML
private  TableColumn<Product, String> productName;
@FXML
private  TableColumn<Product, Double> sellingPrice;
@FXML
private  TableColumn<Product, Integer> quantity;
@FXML
private  TableColumn<Product, String> productCode;
@FXML
private  TableColumn<Product, Double> costPrice;
@FXML
private TableColumn<Product, String> categoryName;

@FXML
        private TextField tfSearch;



    Connection connection = TestConnection.ConnectionUtil.connectdb();
    ObservableStack<Product> listMs;
    ObservableStack<Product> dataList;
@FXML
private ComboBox catComboBox,catComboBox2;

 public ObservableList<Object> Combo(){
     Connection connection = TestConnection.ConnectionUtil.connectdb();
     String string = "SELECT Category_ID FROM Category";
     ObservableList<Object> observableList = FXCollections.observableArrayList();
     try {
        // PreparedStatement ps = connection.prepareStatement(string);
         //ResultSet rs = ps.executeQuery();
        ResultSet rs = connection.createStatement().executeQuery(string);
         while (rs.next()) {
             observableList.add(rs.getString("Category_ID"));

         }

         System.out.println(observableList);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }

     return observableList;
 }

 public void Comboc(){
     catComboBox.getItems().addAll(Combo());
 }

 public ObservableList<Object> comboX(){
     Connection connection = TestConnection.ConnectionUtil.connectdb();
     String string = "SELECT Category_Name FROM Category";
     ObservableList<Object> observableList = FXCollections.observableArrayList();
     try {
         // PreparedStatement ps = connection.prepareStatement(string);
         //ResultSet rs = ps.executeQuery();
         ResultSet rs = connection.createStatement().executeQuery(string);
         while (rs.next()) {
             observableList.add(rs.getString("Category_Name"));

         }

         System.out.println(observableList);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }

     return observableList;
 }

 public  void combox(){
     catComboBox2.getItems().addAll(comboX());
 }

 public void InsertInto(){
     ProductController pd = new ProductController();
     ProductCategoryManagement pc = new ProductCategoryManagement();
     Random random = new SecureRandom();

     String statement = "INSERT INTO `Product`(`Product_Name`,`Selling_Price`, `Quantity`,`Product_Code`,`Cost_Price`, `Category_ID`)VALUES(?,?,?,?,?,?)";
     try {
         PreparedStatement stack =  connection.prepareStatement(statement);
         stack.setString(1, String.valueOf(productNameText.getText()));
         stack.setString(2, String.valueOf(sellingPriceText.getText()));
         stack.setString(3, String.valueOf(productQuantityText.getText()));
         stack.setString(4,String.valueOf(ThreadLocalRandom.current().nextInt()));
         stack.setString(5,String.valueOf(costPriceText.getText()));
         stack.setString(6,String.valueOf(catComboBox.getValue()));




         stack.executeUpdate();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Successfully Added" + productName.getText(), ButtonType.OK);
         alert.show();
        refreshed();
         search_product();

     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }


    public void refreshed() {
        productID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Product_ID"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_Name"));
        sellingPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("Selling_Price"));
        quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        productCode.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_Code"));
        costPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("Cost_Price"));
        categoryName.setCellValueFactory(new PropertyValueFactory<Product, String>("Category_Name"));
//        Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + getUsers(), ButtonType.OK);
//        alert.show();
        ProductCategoryManagement pdf = new ProductCategoryManagement();

        if (catComboBox2.getValue().toString().equals("BEVERAGES")) {

            viewProducts.setItems(pdf.getBeverageCategorY());

        } else if (catComboBox2.getValue().equals("BREAD/BAKERY")) {
            viewProducts.setItems(pdf.getBakeyCategory());
        } else if (catComboBox2.getValue().equals("CANNED/JARRED GOODS")) {
            viewProducts.setItems(pdf.getCannedCategory());
        } else if (catComboBox2.getValue().equals("DAIRY")) {
            viewProducts.setItems(pdf.getDairyCategory());
        } else if (catComboBox2.getValue().equals("DRY/BAKING GOODS")) {
            viewProducts.setItems(pdf.getDryCategory());
        } else if (catComboBox2.getValue().equals("FROZEN FOODS")) {
            viewProducts.setItems(pdf.getFrozenCategory());
        } else if (catComboBox2.getValue().equals("MEAT")) {
            viewProducts.setItems(pdf.getMeatCategory());
        } else if (catComboBox2.getValue().equals("PRODUCE")) {
            viewProducts.setItems(pdf.getProduceCategory());
        } else if (catComboBox2.getValue().equals("CLEANERS")) {
            viewProducts.setItems(pdf.getCleanersCategory());
        } else if (catComboBox2.getValue().equals("PAPER GOODS")) {
            viewProducts.setItems(pdf.getPaperFoodCategory());
        } else if (catComboBox2.getValue().equals("PERSONAL CARE")) {
            viewProducts.setItems(pdf.getPersonalCategories());
        } else if (catComboBox2.getValue().toString().equals("")){


            viewProducts.setItems(pdf.getCategories());
        }
    }


    @FXML
    void search_product() {

        productName.setCellValueFactory(new PropertyValueFactory<Product,String>("Product_Name"));
        categoryName.setCellValueFactory(new PropertyValueFactory<Product,String>("Category_Name"));


        ProductCategoryManagement testConnection = new ProductCategoryManagement();
        dataList = testConnection.getCategories();
        viewProducts.setItems((dataList));
        FilteredList<Product> filteredData = new FilteredList<>(dataList, b -> true);
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (product.getProduct_Name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (product.getCategory_Name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }

                else
                    return false; // Does not match.
            });
        });
        SortedList<Product> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(viewProducts.comparatorProperty());
        viewProducts.setItems(sortedData);
    }

    public void delete() {
        ProductCategoryManagement pcm = new ProductCategoryManagement();

        productID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Product_ID"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_Name"));
        sellingPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("Selling_Price"));
        quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        productCode.setCellValueFactory(new PropertyValueFactory<Product, String>("Product_Code"));
        costPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("Cost_Price"));
        categoryName.setCellValueFactory(new PropertyValueFactory<Product, String>("Category_Name"));
//        Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + getUsers(), ButtonType.OK);

        if (catComboBox2.getValue().toString().equals("BEVERAGES")) {
           viewProducts.setItems(pcm.deleteBe());
        } else if (catComboBox2.getValue().toString().equals("BREAD/BAKERY")) {
            viewProducts.setItems(pcm.deleteBakeyCategory());
        } else if (catComboBox2.getValue().toString().equals("CANNED/JARRED GOODS")) {
            viewProducts.setItems(pcm.deleteCannedCategory());
        } else if (catComboBox2.getValue().toString().equals("DAIRY")) {
            viewProducts.setItems(pcm.getDairyCategory());
        } else if (catComboBox2.getValue().toString().equals("DRY/BAKING GOODS")) {
            viewProducts.setItems(pcm.deleteDryCategory());
        } else if (catComboBox2.getValue().toString().equals("FROZEN FOODS")) {
            viewProducts.setItems(pcm.deleteFrozenCategory());
        } else if (catComboBox2.getValue().toString().equals("MEAT")) {
            viewProducts.setItems(pcm.deleteMeatCategory());
        } else if (catComboBox2.getValue().toString().equals("PRODUCE")){
            Delete();
        } else if (catComboBox2.getValue().toString().equals("CLEANERS")) {
            Delete();
        } else if (catComboBox2.getValue().toString().equals("PAPER GOODS")) {
            Delete();
        } else if (catComboBox2.getValue().toString().equals("PERSONAL CARE")) {
            Delete();
        }
    }











    //Implementing the Delete Method
    public void Delete() {

        Connection conn = TestConnection.ConnectionUtil.connectdb();
        String sql = "delete from Product where Product_ID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, productIDTextField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            refreshed();
            search_product();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
