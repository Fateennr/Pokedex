package com.example.pokedex_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.IIOParam;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DashboardController implements Initializable {

    @FXML
    private Label attack;

    @FXML
    private VBox chosenPokemonCard;

    @FXML
    private Label defense;

    @FXML
    private ImageView pokeImg;

    @FXML
    private GridPane grid;

    @FXML
    private Label pokemonnamelabel;

    @FXML
    private Label pokemontotallabel;

    @FXML
    private ScrollPane scroll;

    private List<Pokemon> pokemons = new ArrayList<>();

    public MyListener myListener;

    private Pokemon pokemon;



    public List<Pokemon> getData()
    {
            try {
                // Establish database connection
                dbcontroller connection = new dbcontroller();
                Connection connectDB = connection.getConnection();

                // Prepare the SQL statement
                String fetchQuery = "SELECT id, Type, Name, HP, Attack, Defense, `Sp.Atk`, `Sp.Def`, Speed, Total FROM pokemons";

                // Create a PreparedStatement to execute the query
                PreparedStatement preparedStatement = connectDB.prepareStatement(fetchQuery);

                // Execute the query and get the result set
                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate over the result set
                while (resultSet.next()) {
                    System.out.println("going");
                    // Create a new Pokemon instance for each row
                    Pokemon pokemon = new Pokemon();

                    pokemon.setid(resultSet.getInt("id"));
                    pokemon.setType(resultSet.getString("Type"));
                    pokemon.setName(resultSet.getString("Name"));
                    pokemon.setHP(resultSet.getInt("HP"));
                    pokemon.setAttack(resultSet.getInt("Attack"));
                    pokemon.setDefense(resultSet.getInt("Defense"));
                    pokemon.setSpecialAttack(resultSet.getInt("Sp.Atk"));
                    pokemon.setSpecialDefense(resultSet.getInt("Sp.Def"));
                    pokemon.setSpeed(resultSet.getInt("Speed"));
                    pokemon.settotal(resultSet.getInt("Total"));

                    pokemons.add(pokemon);
                }

                // Close resources
                resultSet.close();
                preparedStatement.close();
                connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return pokemons;
    }


    private void setChosenPokeomon(Pokemon pokemon)
    {
        pokemonnamelabel.setText(pokemon.getName());
        pokemontotallabel.setText(""+ pokemon.getTotal());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/"+pokemon.getName() + ".png")));

        attack.setText(""+pokemon.getAttack());
        defense.setText(""+pokemon.getDefense());

        pokeImg.setImage(image);
        chosenPokemonCard.setStyle("-fx-background-color: " + pokemon.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getData();

        if (pokemons.size() > 0)
        {
            setChosenPokeomon(pokemons.get(0));
            myListener = new MyListener() {

                @Override
                public void onClickListener(Pokemon __pokemon) {
                    setChosenPokeomon(__pokemon);
                    pokemon = __pokemon;
                }

            };
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < pokemons.size(); i++)
            {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pokemon.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                InfoController infoController = fxmlLoader.getController();

                infoController.setData(pokemons.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void DetailsPage(Pokemon pokemon)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPage.fxml"));
            Parent root = loader.load();

            DetailsController controller = loader.getController();
            controller.setImage(pokemon.getName());

            // Set up the primary stage
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root, 800, 600)); // Set the scene with a specific width and height
            primaryStage.show(); // Display the window
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load startscene.fxml.");
        }

    }

    @FXML
    void onDetailesClicked(MouseEvent event) {

        DetailsPage(pokemon);
    }


}
