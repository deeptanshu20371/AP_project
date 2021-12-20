package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;




public class Game {
    private Parent root;
    @FXML
    private Button back_button;


    @FXML
    void go_back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 800);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Snakes and Ladders");
        stage.setScene(scene);
        stage.show();
    }

}