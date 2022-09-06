package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import com.example.g22dsainventorysystem.structures.Category;
import com.example.g22dsainventorysystem.structures.ObservableStack;
import com.example.g22dsainventorysystem.structures.TestConnection;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryController {

@FXML
private TextField categoryName,tfSearch;

@FXML
private TextArea categoryDescription;



    @FXML
    private Button btnCancelupdate;

    @FXML
    private Button buttonSaveupdate;

@FXML
private Button buttonSave;
@FXML
private Button btnCancel;

@FXML
private TableView<Category> categoryTable;
@FXML
private TableColumn<Category, String> viewCategoryName;
@FXML
private TableColumn<Category, String> viewCategoryDescription;

@FXML
private  TableColumn<Category, Integer> viewCategoryId;

ListView <Category> listView;
StackPane stackPane;

ObservableStack<Category> listMs;
ObservableStack<Category> dataList;
    Connection connection = TestConnection.ConnectionUtil.connectdb();

public void insert(javafx.event.ActionEvent activeEvent){
    String stateMent = "INSERT INTO `Category`(`Category_Name`, `Description`)VALUES(?,?)";
    try {
        PreparedStatement ps = connection.prepareStatement(stateMent);
        ps.setString(1,String.valueOf(categoryName.getText()));
        ps.setString(2,String.valueOf(categoryDescription.getText()));

        ps.executeUpdate();
        update();
        search_category();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}


    public void update(){

        viewCategoryId.setCellValueFactory(new PropertyValueFactory<Category, Integer>("Category_ID"));
        viewCategoryName.setCellValueFactory(new PropertyValueFactory<Category,String>("Category_Name"));
        viewCategoryDescription.setCellValueFactory(new PropertyValueFactory<Category, String>("Description"));
        TestConnection testConnection = new TestConnection();
        listMs = testConnection.getCategories();
        categoryTable.setItems(listMs);
        //categoryTable.setUserData(listMs);




    }


    @FXML
    void search_category() {

        //col_id.setCellValueFactory(new PropertyValueFactory<Vendors,Integer>("id"));
        //viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vender_ID"));
        viewCategoryName.setCellValueFactory(new PropertyValueFactory<Category,String>("Category_Name"));
        viewCategoryDescription.setCellValueFactory(new PropertyValueFactory<Category,String>("PhoneNumber"));


        TestConnection testConnection = new TestConnection();
        dataList = testConnection.getCategories();
        categoryTable.setItems((ObservableList<Category>) dataList);
        FilteredList<Category> filteredData = new FilteredList<>((ObservableList<Category>) dataList, b -> true);
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(category -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (category.getCategory_Name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (category.getCategory_Name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }else if (category.getCategory_Name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }
                else if (String.valueOf(category.getDescription()).indexOf(lowerCaseFilter)!=-1)
                    return true;// Filter matches email

                else
                    return false; // Does not match.
            });
        });
        SortedList<Category> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(categoryTable.comparatorProperty());
        categoryTable.setItems(sortedData);
    }
    @FXML
    public void addCategory(ActionEvent event) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/Products/AddCategory.fxml");
        FXMLLoader loader1 = new FXMLLoader(fxmlLocation);
        try {
            loader1.load();
            Parent parent = loader1.getRoot();
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
    public void updateCategory() {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/Products/updatProductCategory.fxml");
        FXMLLoader loader1 = new FXMLLoader(fxmlLocation);
        try {
            loader1.load();
            Parent parent = loader1.getRoot();
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
    public void delete() {
    }
    @FXML
    public void Cancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }


    public void CancelUpdate(ActionEvent event) {
        Stage stage = (Stage)  btnCancelupdate.getScene().getWindow();
        stage.close();
    }
}
