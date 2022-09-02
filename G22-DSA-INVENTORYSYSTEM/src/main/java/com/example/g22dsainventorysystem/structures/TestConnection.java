package com.example.g22dsainventorysystem.structures;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TestConnection {



    public class ConnectionUtil {
        Connection conn = null;

        public static Connection connectdb() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "Eselase12/.");
                return conn;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
        }
    }

    public ObservableList<Vendors> getDatausers() {
        Connection conn = ConnectionUtil.connectdb();
        ObservableList<Vendors> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from vendor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Vendors(rs.getInt("Vendor_ID"), rs.getString("Vendor_Name"), rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Location"), rs.getString("Address")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ObservableStack<Category> getCategories() {
        Connection connection = ConnectionUtil.connectdb();
        ObservableStack<Category> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Category(resultSet.getInt("Category_ID"), resultSet.getString("Category_Name"), resultSet.getString("Description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }
    ObservableList<MapEntry<String, Vendors>> entries = FXCollections.observableArrayList();

    public ObservableMap<String, Vendors> getVendors() {
        Vendors vendors = new Vendors();
        Connection connection = ConnectionUtil.connectdb();
        ObservableMap<String, Vendors> map = FXCollections.observableHashMap();


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

    public ObservableHashMap<String, Vendors> getVendor() {
        Vendors vendors = new Vendors();
        Connection connection = ConnectionUtil.connectdb();
        ObservableHashMap<String, Vendors> hashMap = new ObservableHashMap<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from vendor");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                hashMap.put(String.valueOf(vendors.getVendor_Name()), new Vendors(resultSet.getInt("Vendor_ID"),
                        resultSet.getString("Vendor_Name"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"), resultSet.getString("Location"),
                        resultSet.getString("Address")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hashMap;
    }

    public ObservableList<Map<String, Vendors>> getMyVendors() {
        Vendors vendors = new Vendors();
        Connection connection = ConnectionUtil.connectdb();
        ObservableList<Map<String, Vendors>> maps = FXCollections.observableArrayList();
        Map<String, Vendors> hashmap = new HashMap<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from vendor");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                hashmap.put(String.valueOf(vendors.getVendor_Name()), new Vendors(resultSet.getInt("Vendor_ID"),
                        resultSet.getString("Vendor_Name"), resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"), resultSet.getString("Location"),
                        resultSet.getString("Address")));
                maps.add(hashmap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return maps;

    }
}