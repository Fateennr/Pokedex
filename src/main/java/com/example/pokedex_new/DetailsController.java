//package com.example.pokedex_new;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.geometry.Insets;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Region;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.shape.Rectangle;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//import static com.example.pokedex_new.Pokemon.*;
//
//public class DetailsController implements Initializable
//{
//
//    String img;
//
//    @FXML
//    private ImageView DetailsImg;
//
//
//    @FXML
//    private Rectangle AttackBar;
//
//    @FXML
//    private TextArea Bio;
//
//    @FXML
//    private TextField CatchRateText;
//
//    @FXML
//    private Rectangle DefBar;
//
//    @FXML
//    private ImageView FirstGenImg;
//
//    @FXML
//    private Rectangle HpBar;
//
//    @FXML
//    private Label PokemonName;
//
//    @FXML
//    private ImageView SecGenImg;
//
//    @FXML
//    private TextField SpAbilityText;
//
//    @FXML
//    private Rectangle SpAtkBar;
//
//    @FXML
//    private Rectangle SpDefBar;
//
//    @FXML
//    private Rectangle SpeedBar;
//
//    @FXML
//    private ImageView ThirdgenImg;
//
//    @FXML
//    private Rectangle Totalbar;
//
//    @FXML
//    private TextField TypeFont;
//
//    @FXML
//    private Rectangle TypeRect;
//
//    @FXML
//    private TextField WeightText;
//
//    Pokemon pokemon = getInstance();
//
//
////    public void setImage(String img)
////    {
////        this.img = img;
////        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/"+img + ".png")));
////        DetailsImg.setImage(image);
////    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources)
//    {
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/"+pokemon.getName() + ".png")));
//        DetailsImg.setImage(image);
//    }
//
//
//
//
//}

package com.example.pokedex_new;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {


    @FXML
    private Label AtkVal;

    @FXML
    private Rectangle AttackBar;

    @FXML
    private Label Bio;

    @FXML
    private Label CatchRateText;

    @FXML
    private Rectangle DefBar;

    @FXML
    private Label DefVal;

    @FXML
    private ImageView DetailsImg;

    @FXML
    private ImageView FirstGenImg;

    @FXML
    private Label HeightInfoText;

    @FXML
    private Rectangle HpBar;

    @FXML
    private Label HpVal;

    @FXML
    private Label PokemonName;

    @FXML
    private ImageView SecGenImg;

    @FXML
    private Label SpAbilityText;

    @FXML
    private Rectangle SpAtkBar;

    @FXML
    private Label SpAtkVal;

    @FXML
    private Rectangle SpDefBar;

    @FXML
    private Label SpDefVal;

    @FXML
    private Rectangle SpeedBar;

    @FXML
    private Label SpeedVal;

    @FXML
    private ImageView ThirdgenImg;

    @FXML
    private Label TotalVal;

    @FXML
    private Rectangle Totalbar;

    @FXML
    private Label TypeFont;

    @FXML
    private Rectangle TypeRect;

    @FXML
    private Label WeightText;

    Pokemon pokemon = Pokemon.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + pokemon.getName() + ".png")));
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/pikachu.png")));

        DetailsImg.setImage(image);

        System.out.println("gg " + pokemon.getHeightInfo());

        AtkVal.setText("" + pokemon.getAttack());
        DefVal.setText("" + pokemon.getDefense());
        SpAtkVal.setText("" + pokemon.getSpecialAttack());
        SpDefVal.setText("" + pokemon.getDefense());
        SpeedVal.setText("" + pokemon.getSpeed());
        HpVal.setText("" + pokemon.getHp());
        SpDefVal.setText("" + pokemon.getSpecialDefense());
        TotalVal.setText("" + pokemon.getTotal());
        PokemonName.setText(pokemon.getName());
        HeightInfoText.setText(pokemon.getHeightInfo());
        Bio.setText(pokemon.getBio());
        SpAbilityText.setText(pokemon.getAbility());
        WeightText.setText(pokemon.getWeight());
        CatchRateText.setText(Float.toString(pokemon.getCatchRate()));
        TypeRect.setStyle("-fx-fill: " + pokemon.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
        TypeFont.setText(pokemon.getType());
        setStatsLength();
        setEvolutionImages();
    }




    private void setStatsLength()
    {
        AttackBar.setWidth(pokemon.getAttack() * 3);
        DefBar.setWidth(pokemon.getDefense() * 3);
        SpAtkBar.setWidth(pokemon.getSpecialAttack() * 3);
        SpDefBar.setWidth(pokemon.getSpecialDefense() * 3);
        SpeedBar.setWidth(pokemon.getSpeed() * 3);
        Totalbar.setWidth(pokemon.getTotal() * 0.6); // Adjust multiplier as needed

        // Set color for TypeRect based on value range
        int attack = pokemon.getAttack();
        if (attack >= 0 && attack < 20) {
            AttackBar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (attack >= 20 && attack < 40) {
            AttackBar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (attack >= 40 && attack < 60) {
            AttackBar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (attack >= 60 && attack < 80) {
            AttackBar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            AttackBar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }

        // Set color for TypeRect based on value range
        int total_d = pokemon.getDefense();
        if (total_d >= 0 && total_d < 20) {
            DefBar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (total_d >= 20 && total_d < 40) {
            DefBar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (total_d >= 40 && total_d < 60) {
            DefBar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (total_d >= 60 && total_d < 80) {
            DefBar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            DefBar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }

        // Set color for TypeRect based on value range
        int spatkbar = pokemon.getSpecialAttack();
        if (spatkbar >= 0 && spatkbar < 20) {
            SpAtkBar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (spatkbar >= 20 && spatkbar < 40) {
            SpAtkBar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (spatkbar >= 40 && spatkbar < 60) {
            SpAtkBar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (spatkbar >= 60 && spatkbar < 80) {
            SpAtkBar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            SpAtkBar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }

        // Set color for TypeRect based on value range
        int spdef = pokemon.getSpecialDefense();
        if (spdef >= 0 && spdef < 20) {
            SpDefBar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (spdef >= 20 && spdef < 40) {
            SpDefBar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (spdef >= 40 &&spdef < 60) {
            SpDefBar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (spdef >= 60 && spdef < 80) {
            SpDefBar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            SpDefBar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }

        // Set color for TypeRect based on value range
        int speed = pokemon.getSpeed();
        if (speed >= 0 && speed < 20)
        {
            SpeedBar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (speed >= 20 && speed < 40) {
            SpeedBar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (speed >= 40 && speed < 60) {
            SpeedBar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (speed >= 60 && speed < 80) {
            SpeedBar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            SpeedBar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }


        int total = pokemon.getTotal();
        if (total >= 0 && total < 120)
        {
            Totalbar.setStyle("-fx-fill: #FF0000; -fx-background-radius: 30;"); // Red for low values
        } else if (total >= 120 && total < 240) {
            Totalbar.setStyle("-fx-fill: #FFA500; -fx-background-radius: 30;"); // Orange for medium values
        } else if (total >= 240 && total < 360) {
            Totalbar.setStyle("-fx-fill: #FFFF00; -fx-background-radius: 30;"); // Yellow for higher medium values
        } else if (total >= 360 && total < 540) {
            Totalbar.setStyle("-fx-fill: #00FF00; -fx-background-radius: 30;"); // Green for high values
        } else {
            Totalbar.setStyle("-fx-fill: #0000FF; -fx-background-radius: 30;"); // Blue for very high values
        }
    }


    private void setEvolutionImages() {
        try {
            // Establish database connection
            dbcontroller connection = new dbcontroller();
            Connection connectDB = connection.getConnection();

            // Prepare the SQL statement to fetch evolution data and corresponding Pokemon names
            String fetchQuery = "SELECT p1.Name AS first_name, p2.Name AS second_name, p3.Name AS third_name \n" +
                    "FROM evolution e \n" +
                    "LEFT JOIN pokemons p1 ON e.first_id = p1.id \n" +
                    "LEFT JOIN pokemons p2 ON e.second_id = p2.id \n" +
                    "LEFT JOIN pokemons p3 ON e.third_id = p3.id \n" +
                    "WHERE ? IN (e.first_id, e.second_id, e.third_id);";

            // Create a PreparedStatement to execute the query
            PreparedStatement preparedStatement = connectDB.prepareStatement(fetchQuery);
            preparedStatement.setString(1, ""+pokemon.getid());

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if there is a result
            if (resultSet.next()) {
                // Retrieve Pokemon names from the result set
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String thirdName = resultSet.getString("third_name");

                System.out.println("gg "+firstName);
                // Load evolution images if names are not null
                if (firstName != null)
                {
                    loadImage(firstName, FirstGenImg);
                }
                else{
                    loadImage("logo", FirstGenImg);

                }
                if (secondName != null) {
                    loadImage(secondName, SecGenImg);
                }
                else{
                    loadImage("logo", FirstGenImg);

                }
                if (thirdName != null) {
                    loadImage(thirdName, ThirdgenImg);
                }
                else{
                    loadImage("logo", ThirdgenImg);

                }
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connectDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadImage(String name, ImageView imageView)
    {
        // Load the corresponding image for the Pokemon name
        Image image = new Image(getClass().getResourceAsStream("detailed/" + name.toLowerCase() + ".png"));
        imageView.setImage(image);
    }
}

//    private void setEvolutionImages()
//    {
//
//        try {
//            // Establish database connection
//            dbcontroller connection = new dbcontroller();
//            Connection connectDB = connection.getConnection();
//
//            // Prepare the SQL statement
//            String fetchQuery = "SELECT Name from pokemons where id = (select id from evlutions where id in first_id, second_id, third_id FROM evolution ";
//
//            // Create a PreparedStatement to execute the query
//            PreparedStatement preparedStatement = connectDB.prepareStatement(fetchQuery);
//
//            // Execute the query and get the result set
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            // Iterate over the result set
//            while (resultSet.next())
//            {
//                // Create a new Pokemon instance for each row
//                Pokemon pokemon = new Pokemon();
//
//                resultSet.getString("Name");
//        // Fetch and display evolutionary stage images
//        // Assuming you have the methods to get evolutionary stage IDs and their images
//        // Example:
//        // FirstGenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getFirstId() + ".png"))));
//        // SecGenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getSecondId() + ".png"))));
//        // ThirdgenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getThirdId() + ".png"))));
//    }

//    private Color getTypeColor(String type) {
//        // Implement logic to map type to color
//        // Example:
//        if (type.equalsIgnoreCase("Fire")) {
//            return Color.RED;
//        } else if (type.equalsIgnoreCase("Water")) {
//            return Color.BLUE;
//        } else if (type.equalsIgnoreCase("Grass")) {
//            return Color.GREEN;
//        } else {
//            return Color.BLACK;
//        }
//    }
//} catch (SQLException e) {
//            throw new RuntimeException(e);
//        }



