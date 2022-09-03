package com.example.g22dsainventorysystem.structures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryManagement {


    public  ProductCategoryManagement(){}

    public ObservableStack<Category> getCategories() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Category> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product*, Category.Category_Name FROM Category INNER JOIN Category ON Product.Category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Category(resultSet.getInt("Category_ID"), resultSet.getString("Category_Name"), resultSet.getString("Description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }
}
