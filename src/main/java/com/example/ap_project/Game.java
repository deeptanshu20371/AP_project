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
        Scene scene;
        Parent root= FXMLLoader.load(getClass().getResource("Snakes_and_Ladders.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}