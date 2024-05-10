package com.example.pokedex_new;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

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

    private MyListener myListener;


    @FXML
    void click(MouseEvent event)
    {
        myListener.onClickListener(pokemon);
    }

    void setData(Pokemon pokemon, MyListener myListener)
    {
        System.out.println("invoked");
        this.pokemon = pokemon;

//        System.out.println(pokemon.getid());
//        System.out.println(pokemon.getColor());
//        System.out.println(pokemon.getName());
//        System.out.println(pokemon.getHp());
//        System.out.println(pokemon.getAttack());
//        System.out.println(pokemon.getDefense());
//        System.out.println(pokemon.getSpecialAttack());
//        System.out.println(pokemon.getSpecialDefense());
//        System.out.println(pokemon.getSpeed());
//        System.out.println(pokemon.getTotal());
//        System.out.println(pokemon.getBio());
//        System.out.println(pokemon.getSpecies());
        System.out.println(pokemon.getHeightinfo());
//        System.out.println(pokemon.getWeight());
//        System.out.println(pokemon.getAbility());
//        System.out.println(pokemon.getCatchRate());

        pokename.setText(pokemon.getName());
        poketype.setText(pokemon.getType());
        this.myListener = myListener;

        Image image;
        try {
            image = new Image(getClass().getResourceAsStream("all/"+ pokemon.getName().toLowerCase() + ".png"));
        } catch (Exception e) {
            // If the image for the specific Pokemon is not found, set default image
            image = new Image(getClass().getResourceAsStream("detailed/logo.png"));
        }
//        Image image = new Image(getClass().getResourceAsStream("charizard.png"));
        pokepane.setStyle("-fx-background-color: "+ pokemon.getColor() +";");
        poketype.setStyle("-fx-background-color: " + pokemon.getTypecolor()+ ";");

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

