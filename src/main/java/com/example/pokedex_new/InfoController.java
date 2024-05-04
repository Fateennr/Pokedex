package com.example.pokedex_new;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class InfoController {

    @FXML
    private ImageView img;

    @FXML
    private Label pokename;

    @FXML
    private Label poketype;

    private Pokemon pokemon;

    @FXML
    private AnchorPane pokepane;

    @FXML
    void click(MouseEvent event) {

    }

    void setData(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        pokename.setText(pokemon.getName());
        poketype.setText(pokemon.getType());
//        Image image = new Image(getClass().getResourceAsStream(pokemon.getName()+".png"));
        Image image = new Image(getClass().getResourceAsStream("charizard.png"));
        pokepane.setStyle("-fx-background-color: "+ pokemon.getColor() +";"); // Red color for fire type

        img.setImage(image);
    }

//    private Fruit fruit;
////    private MyListener myListener;
//
//    public void setData(Fruit fruit, MyListener myListener) {
//        this.fruit = fruit;
//        this.myListener = myListener;
//        nameLabel.setText(fruit.getName());
//        priceLable.setText(Main.CURRENCY + fruit.getPrice());
//        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
//        img.setImage(image);
//    }

}

