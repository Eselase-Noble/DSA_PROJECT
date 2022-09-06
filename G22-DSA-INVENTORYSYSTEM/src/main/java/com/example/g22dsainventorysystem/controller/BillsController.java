package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.HelloApplication;
import com.example.g22dsainventorysystem.models.Bills;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillsController {


@FXML
private TextField tfSearch,billIDTextField;
@FXML

 private TextArea    issueIDTextField,   prroductNameText,VendorNameText,totalAmountText;

@FXML
private DatePicker datePicker;

@FXML
private ComboBox paymentComboBox;

@FXML
private TableView<Bills> viewBills;
@FXML
        private TableColumn <Bills, Integer>viewBilID;

@FXML
    private TableColumn <Bills, Integer>viewIssuedID;
@FXML
    private TableColumn <Bills, String>viewProductName;

@FXML
private TableColumn<Bills, DatePicker>Paydate;

@FXML
    private TableColumn <Bills, String>viewVendoName;
@FXML
    private TableColumn <Bills, Double>viewTotalAmount;

    @FXML
    private TableColumn <Bills, String>viewPayment;
    @FXML
    private Button btnCancel;



    ObservableList<Bills> listMs;
    ObservableList<Bills> dataList;


    Connection connection = TestConnection.ConnectionUtil.connectdb();
    public void insert(javafx.event.ActionEvent activeEvent){
        String stateMent = "INSERT INTO `Bills`(`Issued_ID`, `Product_Name`, `Date`, `TotalAmount`, `Payment_Type`,`Vendor_Name`)VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(stateMent);
            ps.setString(1, String.valueOf(issueIDTextField.getText()));
            ps.setString(2,String.valueOf(prroductNameText.getText()));
            ps.setString(3,String.valueOf(datePicker.getValue()));
            ps.setString(4,String.valueOf(totalAmountText.getText()));
            ps.setString(5,String.valueOf(paymentComboBox.getValue()));
            ps.setString(6,String.valueOf(VendorNameText.getText()));


            ps.executeUpdate();
            updates();
            search_category();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void updates(){

        viewBilID.setCellValueFactory(new PropertyValueFactory<Bills, Integer>("Bill_ID"));
        viewPayment.setCellValueFactory(new PropertyValueFactory<Bills, String>("Payment_Type"));
        viewTotalAmount.setCellValueFactory(new PropertyValueFactory<Bills, Double>("TotalAmount"));
        Paydate.setCellValueFactory(new PropertyValueFactory<Bills, DatePicker>("Date"));
        viewIssuedID.setCellValueFactory(new PropertyValueFactory<Bills,Integer>("Issued_ID"));
        viewProductName.setCellValueFactory(new PropertyValueFactory<Bills, String>("Product_Name"));
        viewVendoName.setCellValueFactory(new PropertyValueFactory<Bills, String>("Vendor_Name"));


        LetConnects letConnects = new LetConnects();
        listMs = letConnects.getBills();
        viewBills.setItems(listMs);
        //categoryTable.setUserData(listMs);




    }




    @FXML
    void search_category() {

        //col_id.setCellValueFactory(new PropertyValueFactory<Vendors,Integer>("id"));
        //viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vender_ID"));
        viewProductName.setCellValueFactory(new PropertyValueFactory<Bills, String>("Product_Name"));
        //viewCategoryDescription.setCellValueFactory(new PropertyValueFactory<Category, String>("PhoneNumber"));


        LetConnects letConnects = new LetConnects();
        listMs = letConnects.getBills();
        viewBills.setItems(dataList);
        FilteredList<Bills> filteredData = new FilteredList<>( dataList, b -> true);
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(bills -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (bills.getProduct_Name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }

                else
                    return false; // Does not match.
            });
        });
        SortedList<Bills> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(viewBills.comparatorProperty());
        viewBills.setItems(sortedData);

    }


    public void addBill(ActionEvent event) {
        URL fxmlLocation = HelloApplication.class.getResource("view/screens/Bills/AddBill.fxml");
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

    public void close(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void comboItems(){
        paymentComboBox.getItems().addAll(
                "Cash",
                "Mobile  Money",
                "Card"
        );
    }
}
