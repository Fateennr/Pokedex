package com.example.pokedex_new;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        try {
            fxmlLoader.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        } catch (Exception e) {
            System.err.println("Error loading CSS file: " + e.getMessage());
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(fxmlLoader, 1315, 810)); // Set the scene with  a specific width and height
        primaryStage.setTitle("Pokedex");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}