module com.example.pokedex_new {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pokedex_new to javafx.fxml;
    exports com.example.pokedex_new;
}