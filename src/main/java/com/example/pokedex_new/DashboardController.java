package com.example.pokedex_new;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private GridPane grid;

    @FXML
    private Label id;

    @FXML
    private ImageView pokeImg;

    @FXML
    private Label pokemonnamelabel;

    @FXML
    private Label pokemontotallabel;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    private List<Pokemon> pokemons = new ArrayList<>();

    public MyListener myListener;

    private Pokemon pokemon = Pokemon.getInstance();


    public List<Pokemon> getData() {


        try {
            // Establish database connection
            dbcontroller connection = new dbcontroller();
            Connection connectDB = connection.getConnection();

            // Prepare the SQL statement
            String fetchQuery = "SELECT id, Type, Name, HP, Attack, Defense, `Sp.Atk`, `Sp.Def`, Speed, Total, " +
                    "bio, species, heightinfo, weightinfo, ability, catchrate FROM pokemons";

            // Create a PreparedStatement to execute the query
            PreparedStatement preparedStatement = connectDB.prepareStatement(fetchQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
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
                pokemon.setBio(resultSet.getString("bio"));
                pokemon.setSpecies(resultSet.getString("species"));
                pokemon.setHeightInfo(resultSet.getString("heightinfo"));
                pokemon.setWeightInfo(resultSet.getString("weightinfo"));
                pokemon.setSpecialAbility(resultSet.getString("ability"));
                pokemon.setCatchRate(resultSet.getFloat("catchrate"));

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

    private void setChosenPokemon(Pokemon pokemon) {
        id.setText("#00" + pokemon.getid());
        pokemonnamelabel.setText(pokemon.getName());
        pokemontotallabel.setText("" + pokemon.getTotal());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + pokemon.getName() + ".png")));

        attack.setText("" + pokemon.getAttack());
        defense.setText("" + pokemon.getDefense());

        pokeImg.setImage(image);
        chosenPokemonCard.setStyle("-fx-background-color: " + pokemon.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        searchButton = new Button();
//
//        searchBar = new TextField();
        Setdata(getData());

    }

    private void Setdata(List<Pokemon> pokemons)
    {
        grid.getChildren().clear();
        if (pokemons.size() > 0) {
            setChosenPokemon(pokemons.get(0));
            pokemon.setData(pokemons.get(0));

            myListener = new MyListener() {

                @Override
                public void onClickListener(Pokemon __pokemon) {
                    setChosenPokemon(__pokemon);
                    pokemon.setData(__pokemon);
                }

            };
        }

        int column = 0;
        int row = 1;
        try {
            System.out.println(pokemons.size());
            for (int i = 0; i < pokemons.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pokemon.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                InfoController infoController = fxmlLoader.getController();

//                System


                infoController.setData(pokemons.get(i), myListener);

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


    private void DetailsPage()
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPage.fxml"));
            Parent root = loader.load();


            // Set up the primary stage
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root, 850, 800)); // Set the scene with a specific width and height
            primaryStage.show(); // Display the window
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load startscene.fxml.");
        }

    }

    @FXML
    void onDetailesClicked(MouseEvent event) {
        String gg = searchBar.getText();
        System.out.println("working? "+ gg);
        DetailsPage();
    }


    //Search bar

    @FXML
    void Search(MouseEvent event) throws SQLException
    {
        String keyword;

        keyword = searchBar.getText();

        List<Pokemon> pokemons_search = new ArrayList<>();

        try
        {
            // Establish database connection
            dbcontroller connection = new dbcontroller();
            Connection connectDB = connection.getConnection();



            System.out.println(keyword);

            String fetchQuery;

    //        page_info = "Search";
            if (Objects.equals(keyword, ""))
            {
                fetchQuery = "SELECT * from pokemons";
            }
            else
            {
                keyword = Character.toUpperCase(keyword.charAt(0)) + keyword.substring(1);
                fetchQuery = "SELECT * FROM pokemons WHERE Name LIKE '%" + keyword + "%' OR TYPE LIKE '%" + keyword + "%';";
            }

            // Create a PreparedStatement to execute the query
            PreparedStatement preparedStatement = connectDB.prepareStatement(fetchQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the result set
            while (resultSet.next()) {
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
                pokemon.setBio(resultSet.getString("bio"));
                pokemon.setSpecies(resultSet.getString("species"));
                pokemon.setHeightInfo(resultSet.getString("heightinfo"));
                pokemon.setWeightInfo(resultSet.getString("weightinfo"));
                pokemon.setSpecialAbility(resultSet.getString("ability"));
                pokemon.setCatchRate(resultSet.getFloat("catchrate"));

                pokemons_search.add(pokemon);

                pokemons = pokemons_search;
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connectDB.close();
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }


        Setdata(pokemons);
    }

}




//        if(!pokemons_search.isEmpty()){
//            setChosenPokemon(pokemons_search.getFirst());
//            myListener = new MyListener() {
//                @Override
//                public void onClickListener(Pokemon pokemon) {
//                    setChosenPokemon(pokemon);
//                }
//            };
//        }
//        grid.getChildren().clear();
//        int column = 0;
//        int row = 1;
//
//        try {
//            for (int i = 0; i < pokemons_search.size(); i++) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
//                AnchorPane anchorpane = fxmlLoader.load();
//                InfoController itemcontroller = fxmlLoader.getController();
//                itemcontroller.setData(pokemons_search.get(i), myListener);
//                if (column == 3) {
//                    column = 0;
//                    row++;
//                }
////                anchorpane.setStyle("-fx-background-color: " + color_map.get(pokemons_search.get(i).type1) + ";");
//                grid.add(anchorpane, column++, row);
//                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
//                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                grid.setMaxWidth(Region.USE_PREF_SIZE);
//
//                //set grid height
//                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
//                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                grid.setMaxHeight(Region.USE_PREF_SIZE);
//
//                GridPane.setMargin(anchorpane, new Insets(10));
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
