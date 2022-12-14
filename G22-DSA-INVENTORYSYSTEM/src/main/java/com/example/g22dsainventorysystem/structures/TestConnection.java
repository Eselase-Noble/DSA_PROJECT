package com.example.g22dsainventorysystem.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class TestConnection {



    public class ConnectionUtil {
        Connection conn = null;

        public static Connection connectdb() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
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
                        resultSet.getString("Vendor_Name"), resultSet.getString("PhoneNumber"), resultSet.getString("Email"),
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

}