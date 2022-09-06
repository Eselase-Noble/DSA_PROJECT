package com.example.g22dsainventorysystem.controller;

import com.example.g22dsainventorysystem.structures.TestConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillsController {


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
}
