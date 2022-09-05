package com.example.g22dsainventorysystem.tracks;

import com.example.g22dsainventorysystem.structures.TestConnection;
import com.example.g22dsainventorysystem.structures.Vendors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LetConnects {



    public ObservableList<Vendors> getDatausers() {
        Connection conn = TestConnection.ConnectionUtil.connectdb();
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
}
