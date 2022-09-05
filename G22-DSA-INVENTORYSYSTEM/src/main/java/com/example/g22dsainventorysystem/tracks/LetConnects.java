package com.example.g22dsainventorysystem.tracks;

import com.example.g22dsainventorysystem.models.Bills;
import com.example.g22dsainventorysystem.models.IssuedGoods;
import com.example.g22dsainventorysystem.models.Sales;
import com.example.g22dsainventorysystem.structures.TestConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LetConnects {



    public ObservableList<Bills> getBills() {
        Connection conn = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Bills> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from Bills");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Bills(rs.getInt("Bill_ID"), rs.getString("Payment_Type"),
                        rs.getDouble("TotalAmount"), rs.getDate("Date"), rs.getInt("Issued_ID")));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public ObservableList<IssuedGoods> getIssuedGoods() {
        Connection conn = TestConnection.ConnectionUtil.connectdb();
        ObservableList<IssuedGoods> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from IssuedGoods");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new IssuedGoods(rs.getInt("Issued_ID"), rs.getInt("Quantity"),
                        rs.getInt("Product_ID"), rs.getDouble("Selling_Price"), rs.getDouble("TotalAmount"),rs.getDate("Date")));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public ObservableList<Sales> getSales() {
        Connection conn = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Sales> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from sales");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Sales(rs.getInt("sales_ID"), rs.getInt("Bill_ID"),
                        rs.getInt("Vendor_ID"), rs.getDate("Date")));
            }
        } catch (Exception e) {
        }
        return list;
    }


}
