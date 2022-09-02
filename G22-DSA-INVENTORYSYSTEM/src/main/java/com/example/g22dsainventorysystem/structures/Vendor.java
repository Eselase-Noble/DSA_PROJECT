package com.example.g22dsainventorysystem.structures;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class Vendor {

 public Vendor(){}

    public ObservableMap<String, Vendors> getVendors() {
        Vendors vendors = new Vendors();
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableMap<String, Vendors> map = FXCollections.observableHashMap();

        ObservableList<MapEntry<String, Vendors>> entries = FXCollections.observableArrayList();

        map.addListener((MapChangeListener.Change<? extends String, ? extends Vendors> change) -> {
            boolean removed = change.wasRemoved();
            if (removed != change.wasAdded()) {
                if (removed) {
                    // no put for existing key
                    // remove pair completely
                    entries.remove(new MapEntry<>(change.getKey(), (Vendors) null));
                } else {
                    // add new entry
                    entries.add(new MapEntry<>(change.getKey(), change.getValueAdded()));
                }
            } else {
                // replace existing entry
                MapEntry<String, Vendors> entry = new MapEntry<>(change.getKey(), change.getValueAdded());

                int index = entries.indexOf(entry);
                entries.set(index, entry);
            }
        });

        try {
            PreparedStatement ps = connection.prepareStatement("select * from vendor");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                map.put(String.valueOf(vendors.getVendor_Name()), new Vendors(resultSet.getInt("Vendor_ID"),
                        resultSet.getString("Vendor_Name"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"), resultSet.getString("Location"),
                        resultSet.getString("Address")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return map;
    }



    public void refresh(){
     //TestConnection
    }
}
