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

import java.net.URL;
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

        System.out.println("gg "+pokemon.getHeightInfo());

        AtkVal.setText(""+pokemon.getAttack());
        DefVal.setText(""+pokemon.getDefense());
        SpAtkVal.setText(""+pokemon.getSpecialAttack());
        SpDefVal.setText(""+pokemon.getDefense());
        SpeedVal.setText(""+pokemon.getSpeed());
        HpVal.setText(""+pokemon.getHp());
        SpDefVal.setText(""+pokemon.getSpecialDefense());
        TotalVal.setText(""+pokemon.getTotal());
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
    }

    private void setEvolutionImages()
    {
        // Fetch and display evolutionary stage images
        // Assuming you have the methods to get evolutionary stage IDs and their images
        // Example:
        // FirstGenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getFirstId() + ".png"))));
        // SecGenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getSecondId() + ".png"))));
        // ThirdgenImg.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/" + evolution.getThirdId() + ".png"))));
    }

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
}
