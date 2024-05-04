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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DetailsController implements Initializable
{

    String img;

    @FXML
    private ImageView DetailsImg;

    public void setImage(String img)
    {
        this.img = img;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("detailed/"+img + ".png")));
        DetailsImg.setImage(image);

    }




}
