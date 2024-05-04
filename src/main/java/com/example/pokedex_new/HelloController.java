package com.example.pokedex_new;

import com.example.pokedex_new.dbcontroller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Button test;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

        try {
            // Establish database connection
            dbcontroller connection = new dbcontroller();
            Connection connectDB = connection.getConnection();

            // Prepare the SQL statement
            String insertQuery = "INSERT INTO pokemons (id, Type, Name, HP, Attack, Defense, `Sp.Atk`, `Sp.Def`, Speed) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement to avoid SQL injection
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);

            // Set the values for the parameters
            preparedStatement.setInt(1, 4); // Assuming Total is an integer
            preparedStatement.setString(2, "Fire");
            preparedStatement.setString(3, "Charizard");
            preparedStatement.setInt(4, 78); // Assuming Total is an integer
            preparedStatement.setInt(5, 84);  // Assuming HP is an integer
            preparedStatement.setInt(6, 78);  // Assuming Attack is an integer
            preparedStatement.setInt(7, 109);  // Assuming Defense is an integer
            preparedStatement.setInt(8, 85);  // Assuming Sp.Attack is an integer
            preparedStatement.setInt(9, 100);  // Assuming Sp.Def is an integer

            // Execute the insertion
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }

            // Close resources
            preparedStatement.close();
            connectDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
