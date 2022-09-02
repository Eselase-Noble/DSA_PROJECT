package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.structures.MapEntry;
import com.example.g22dsainventorysystem.structures.TestConnection;
import com.example.g22dsainventorysystem.structures.Vendors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VendorsController {

    TestConnection testConnection = new TestConnection();
    ObservableList<MapEntry<String, Vendors>> entries = FXCollections.observableArrayList();


    @FXML
    TextArea vendorContact,vendorAddress, vendorEmail, vendorLocation;
    @FXML
    TextField vendorName, tfSearch,vendorID;

    TableColumn<Map<String, Vendors>, String> column1 = new TableColumn<>("Key");

    @FXML
    private TableView<Object> viewCustomer ;

    @FXML
    private Button addVendor, btnRefresh;
    @FXML
    private TableColumn< Vendors, String> viewVendorName = new TableColumn<>("Vendor_Name");
    @FXML
    private  TableColumn<Vendors, String> viewVendorCon = new TableColumn<>("PhoneNumber") ;

    @FXML
    private  TableColumn<Vendors, String> viewVendorlocation = new TableColumn<>("Location");

    @FXML
    private  TableColumn<Vendors, String> viewVendorAddress = new TableColumn<>("Address") ;

    @FXML
    private TableColumn<Vendors, Integer> viewVendorID = new TableColumn<Vendors, Integer>("Vendor_ID") ;

    @FXML
    private  TableColumn<Vendors, String> viewVendorEmail = new TableColumn<>("Email");

    ObservableList<Map<String, Vendors>> list;


    public void updates(){



        //viewVendorID.setCellValueFactory(new );

        TestConnection testConnection = new TestConnection();
        list = testConnection.getMyVendors();
        viewCustomer.getColumns();
       // viewCustomer.setItems(list);

//        listM = testConnection.getDatausers();
//        hashMap = testConnection.getVendor();
//        // viewCustomer.setItems((ObservableList<Vendors>) hashMap);
//        viewCustomer.setItems(listM);


    }

    public List<Map<String, Vendors>> getVendors() {
        Vendors vendors = new Vendors();
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        Map<String, Vendors> map = new HashMap<>();
        List<Map<String, Vendors>> observableList = new ArrayList<>();

//
//        map.addListener((MapChangeListener.Change<? extends String, ? extends Vendors> change) -> {
//            boolean removed = change.wasRemoved();
//            if (removed != change.wasAdded()) {
//                if (removed) {
//                    // no put for existing key
//                    // remove pair completely
//                    entries.remove(new MapEntry<>(change.getKey(), (Vendors) null));
//                } else {
//                    // add new entry
//                    entries.add(new MapEntry<>(change.getKey(), change.getValueAdded()));
//                }
//            } else {
//                // replace existing entry
//                MapEntry<String, Vendors> entry = new MapEntry<>(change.getKey(), change.getValueAdded());
//
//                int index = entries.indexOf(entry);
//                entries.set(index, entry);
//            }
//        });

        try {
            PreparedStatement ps = connection.prepareStatement("select * from vendor");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                map.put(String.valueOf(vendors.getVendor_Name()), new Vendors(resultSet.getInt("Vendor_ID"),
                        resultSet.getString("Vendor_Name"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"), resultSet.getString("Location"),
                        resultSet.getString("Address")));
                observableList.add(map);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return observableList;

        //viewCustomer.setItems((ObservableList<MapEntry<String, Vendors>>) map);

        //viewVendorAddress.setCellValueFactory(TableColumn.CellDataFeatures<String,Vendors>cellData)->c);


    }

//    public void refresh(){
//        Vendors vendors = new Vendors();
//        viewVendorID.setCellValueFactory(cd -> Bindings.createStringBinding((Callable<String>) vendors.getVendor_ID()).length());
//        viewVendorName.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map<String, Vendors>, String>, ObservableValue<String>>) vendors.getVendor_Name());
//        viewVendorCon.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map<String, Vendors>, String>, ObservableValue<String>>) vendors.getPhoneNumber());
//        viewVendorEmail.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map<String, Vendors>, String>, ObservableValue<String>>) vendors.getEmail());
//        viewVendorlocation.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map<String, Vendors>, String>, ObservableValue<String>>) vendors.getLocation());
//        viewVendorAddress.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map<String, Vendors>, String>, ObservableValue<String>>) vendors.getAddress());
//
//        viewCustomer.getColumns().setAll(viewVendorID,viewVendorName,viewVendorCon,viewVendorEmail,viewVendorlocation,viewVendorAddress);
//        viewCustomer.setItems(FXCollections.observableArrayList(getVendors()));
//
//    }


    public ObservableList<Object> getUsers(){

        HashMap<Integer, Vendors> hashMap = new HashMap<>();
        ObservableList<Object> list = FXCollections.observableArrayList();
        Vendors vendors = new Vendors();
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM vendor");
        while (resultSet.next()){
            hashMap.put(resultSet.getInt("Vendor_ID"), new Vendors(resultSet.getInt("Vendor_ID"),
                    resultSet.getString("Vendor_Name"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"),
                    resultSet.getString("Location"),resultSet.getString("Address")));
            //list.add(String.valueOf(hashMap));
            list.add(hashMap.get(resultSet.getInt("Vendor_ID")));

            System.out.println(hashMap.get(resultSet.getInt("Vendor_ID")));
            System.out.println(list.get(0));

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }


    public void refreshed(){
        viewVendorID.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("Vendor_ID"));
        viewVendorName.setCellValueFactory(new PropertyValueFactory<Vendors,String>("Vendor_Name"));
        viewVendorCon.setCellValueFactory(new PropertyValueFactory<Vendors, String>("PhoneNumber"));
        viewVendorEmail.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Email"));
        viewVendorlocation.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Location"));
        viewVendorAddress.setCellValueFactory(new PropertyValueFactory<Vendors, String>("Address"));
//        Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + getUsers(), ButtonType.OK);
//        alert.show();
        viewCustomer.setItems(getUsers());
    }



}
