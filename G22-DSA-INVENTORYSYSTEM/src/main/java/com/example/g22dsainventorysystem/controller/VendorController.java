package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.structures.TestConnection;
import com.example.g22dsainventorysystem.structures.Vendors;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendorController {



@FXML
 TextArea vendorContact,vendorAddress, vendorEmail, vendorLocation;
@FXML TextField vendorName, tfSearch,vendorID;

@FXML
private TableView<Vendors> viewCustomer;

@FXML
private Button addVendor, btnRefresh;
@FXML
private TableColumn<Vendors, String> viewVendorName;
@FXML
private  TableColumn<Vendors, String> viewVendorCon;

@FXML
private  TableColumn<Vendors, String> viewVendorlocation;

@FXML
private  TableColumn<Vendors, String> viewVendorAddress;

@FXML
private  TableColumn<Vendors, Integer> viewVendorID;

ObservableList<Vendors> listM;
ObservableList<Vendors> dataList;




@FXML
private  TableColumn<Vendors, String> viewVendorEmail;

Connection connection = TestConnection.ConnectionUtil.connectdb();

ObservableList observableList;
ObservableMap observableMap;

 public void OnActionButton(javafx.event.ActionEvent activeEvent){

     String statement = "INSERT INTO `Vendor`(`Vendor_Name`,`PhoneNumber`, `Email`,`Address`,`Location`)VALUES(?,?,?,?,?)";
     try {
         PreparedStatement stack =  connection.prepareStatement(statement);
         stack.setString(1, String.valueOf(vendorName.getText()));
         stack.setString(2, String.valueOf(vendorContact.getText()));
         stack.setString(3, String.valueOf(vendorEmail.getText()));
         stack.setString(4,String.valueOf(vendorAddress.getText()));
         stack.setString(5,String.valueOf(vendorLocation.getText()));
         //stack.setString(6,String.valueOf(vendorID.getText()));




         stack.executeUpdate();
         update();
         search_user();

     } catch (SQLException e) {
         throw new RuntimeException(e);
     }

 }

 public void update(){

     viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vendor_ID"));
     viewVendorName.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Vendor_Name"));
     viewVendorCon.setCellValueFactory(new PropertyValueFactory<Vendors, String>("PhoneNumber"));
     viewVendorEmail.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Email"));
     viewVendorlocation.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Location"));
     viewVendorAddress.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Address"));


     TestConnection testConnection = new TestConnection();
     listM = testConnection.getDatausers();
     viewCustomer.setItems(listM);


 }

    public void Delete(ActionEvent event){
       Connection conn = TestConnection.ConnectionUtil.connectdb();
        String sql = "delete from users where Vendor_ID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, vendorID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            update();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void UpdateTable(javafx.event.ActionEvent event){
        viewVendorName.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Vendor_Name"));
        viewVendorCon.setCellValueFactory(new PropertyValueFactory<Vendors,String>("PhoneNumber"));
        viewVendorCon.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Email"));
        viewVendorlocation.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Location"));
        viewVendorAddress.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Address"));

        TestConnection testConnection = new TestConnection();
        listM = testConnection.getDatausers();
        viewCustomer.setItems(listM);
    }

    @FXML
    void getSelecteds (MouseEvent event){
        int index = viewCustomer.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        vendorName.setText(viewVendorName.getCellData(index).toString());
        vendorContact.setText(viewVendorCon.getCellData(index).toString());
        vendorEmail.setText(viewVendorEmail.getCellData(index).toString());
        vendorLocation.setText(viewVendorlocation.getCellData(index).toString());
        vendorAddress.setText(viewVendorAddress.getCellData(index).toString());

    }




    @FXML
    void search_user() {

        //col_id.setCellValueFactory(new PropertyValueFactory<Vendors,Integer>("id"));
        //viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vender_ID"));
        viewVendorName.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Vendor_Name"));
        viewVendorCon.setCellValueFactory(new PropertyValueFactory<Vendors,String>("PhoneNumber"));
        viewVendorEmail.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Email"));
        viewVendorlocation.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Location"));
        viewVendorAddress.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Address"));

        TestConnection testConnection = new TestConnection();
        dataList = testConnection.getDatausers();
        viewCustomer.setItems(dataList);
        FilteredList<Vendors> filteredData = new FilteredList<>(dataList, b -> true);
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getVendor_Name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (person.getPhoneNumber().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }
                else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter)!=-1)
                    return true;// Filter matches email

                else
                    return false; // Does not match.
            });
        });
        SortedList<Vendors> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(viewCustomer.comparatorProperty());
        viewCustomer.setItems(sortedData);
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        UpdateTable();
//        search_user();
//        // Code Source in description
//    }

    @FXML
   public void Edit (ActionEvent actionEvent){
        try {
            TestConnection testConnection = new TestConnection();
            Connection conn = TestConnection.ConnectionUtil.connectdb();
            String value1 = vendorName.getText();
            String value2 = vendorContact.getText();
            String value3 = vendorEmail.getText();
            String value4 = vendorLocation.getText();
            String value5 = vendorEmail.getText();
            String value= vendorID.getText();
            String sql = "update users set Vendor_Name= '"+value1+"',PhoneNumber= '"+value2+"',Email= '"+
                    value3+"',Location= '"+value4+"',Address= '"+value5+"' where user_id='"+value+"' ";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            update();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void getSelected(SortEvent<TableView<Vendors>> tableViewSortEvent) {

        int index = viewCustomer.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        vendorID.setText(viewVendorlocation.getCellData(index));
        vendorName.setText(viewVendorName.getCellData(index).toString());
        vendorContact.setText(viewVendorCon.getCellData(index).toString());
        vendorEmail.setText(viewVendorEmail.getCellData(index).toString());
        vendorLocation.setText(viewVendorlocation.getCellData(index).toString());
        vendorAddress.setText(viewVendorAddress.getCellData(index).toString());

    }

    public void Edit(javafx.event.ActionEvent event) {
        try {
            TestConnection testConnection = new TestConnection();
            Connection conn = TestConnection.ConnectionUtil.connectdb();
            String value1 = vendorName.getText();
            String value2 = vendorContact.getText();
            String value3 = vendorEmail.getText();
            String value4 = vendorLocation.getText();
            String value5 = vendorEmail.getText();
            Integer integer = Integer.valueOf(vendorID.getText());
            String sql = "update users set Vendor_Name= '"+value1+"',PhoneNumber= '"+value2+"',Email= '"+
                    value3+"',Location= '"+value4+"',Address= '"+value5+"' where user_id='"+value1+"' ";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            update();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Delete(javafx.event.ActionEvent event) {

        Connection conn = TestConnection.ConnectionUtil.connectdb();
        String sql = "delete from users where Vendor_ID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, vendorID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            update();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }



    }

    public void getSelecteds(javafx.event.ActionEvent event) {
        int index = viewCustomer.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        vendorID.setText(viewVendorID.getCellData(index).toString());
        vendorName.setText(viewVendorName.getCellData(index).toString());
        vendorContact.setText(viewVendorCon.getCellData(index).toString());
        vendorEmail.setText(viewVendorEmail.getCellData(index).toString());
        vendorLocation.setText(viewVendorlocation.getCellData(index).toString());
        vendorAddress.setText(viewVendorAddress.getCellData(index).toString());
    }

//    public void UpdateTable(javafx.event.ActionEvent event) {
//    }

    public void select(){
     Connection connection1 = TestConnection.ConnectionUtil.connectdb();
     String state = "SELECT * FROM vendor";


    }
}




