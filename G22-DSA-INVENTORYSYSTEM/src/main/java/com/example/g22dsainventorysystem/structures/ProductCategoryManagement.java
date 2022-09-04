package com.example.g22dsainventorysystem.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ProductCategoryManagement {

    ObservableStack<Product> stack = new ObservableStack<>();
    public  ProductCategoryManagement(){}

    public ObservableStack<Product> getCategories() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID ;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }


    public ObservableStack<Product> getBeverageCategorY() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'BEVERAGES';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableStack<Product> deleteBe(){
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'BEVERAGES';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"),
                        resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        return stack;


    }


    public ObservableStack<Product> getBakeyCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'BREAD/BAKERY';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }



    public ObservableStack<Product> deleteBakeyCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'BREAD/BAKERY';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        stack.pop();
        return stack;


    }



    public ObservableStack<Product> getCannedCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'CANNED/JARRED GOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableStack<Product> deleteCannedCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'CANNED/JARRED GOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stack.pop();
        return stack;


    }

    public ObservableStack<Product> getDairyCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'DAIRY';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }


    public ObservableStack<Product> deleteDairyCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableStack<Product> stack = new ObservableStack<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'DAIRY';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.push(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stack.pop();
        return stack;


    }



    public ObservableQueue<Product> getDryCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'DRY/BAKING GOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableQueue<Product> deleteDryCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'DRY/BAKING GOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stack.remove();
        return stack;


    }



    public ObservableQueue<Product> getFrozenCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'FROZEN FOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableQueue<Product> deleteFrozenCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'FROZEN FOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        stack.remove();
        return stack;


    }


    public ObservableQueue<Product> getMeatCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'MEAT';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableQueue<Product> deleteMeatCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableQueue<Product> stack = new ObservableQueue<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'MEAT';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        stack.remove();
        return stack;


    }


    public ObservableList<Product> getProduceCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Product> stack = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'PRODUCE';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableList<Product> getCleanersCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Product> stack = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'CLEANERS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return stack;


    }

    public ObservableList<Product> getPaperFoodCategory() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Product> stack = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'PAPER GOODS';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }

    public ObservableList<Product> getPersonalCategories() {
        Connection connection = TestConnection.ConnectionUtil.connectdb();
        ObservableList<Product> stack = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Product.Product_ID,Product.Product_Name,Product.Selling_Price,Product.Quantity,Product.Product_Code,Product.Cost_Price,Category.Category_Name FROM `Product` INNER JOIN `Category` ON Product.Category_ID = Category.Category_ID WHERE Category_Name = 'PERSONAL CARE';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stack.add(new Product(resultSet.getInt("Product_ID"), resultSet.getString("Product_Name"), resultSet.getDouble("Selling_Price"),
                        resultSet.getInt("Quantity"),resultSet.getString("Product_Code"), resultSet.getDouble("Cost_Price"), resultSet.getString("Category_Name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stack;


    }



















    public String randomProductcode(int length)
    {
        int chars[] = new int[]{1,2,3,4,5,6,7,8,9,0};
        var productPassword = new char[length];
        var random = new Random();

        for (int index = 0; index < productPassword.length; index++)
        {
            productPassword[index] = (char) chars[random.nextInt(chars.length)];
        }

        return new String(productPassword);
    }
}
