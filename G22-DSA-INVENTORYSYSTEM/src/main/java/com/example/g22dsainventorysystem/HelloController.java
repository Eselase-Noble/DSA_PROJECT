package com.example.g22dsainventorysystem;

import com.example.g22dsainventorysystem.structures.TestConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Stack;

public class HelloController {
    @FXML
    private Label welcomeText;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void ConnectionController(){
        connection = TestConnection.ConnectionUtil.connectdb();
    }
    @FXML
    public void button(ActionEvent event){

        String sqlStatement = "SELECT * FROM Product WHERE Category_ID = Category.Category_ID ";

        try(Statement statement = connection.createStatement()){
            Stack resultSet1 = (Stack) statement.executeQuery(sqlStatement);



        }
        catch (Exception e){

        }
    }
}