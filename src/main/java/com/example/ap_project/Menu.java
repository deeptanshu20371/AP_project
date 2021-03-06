package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Menu {

    @FXML
    private Button play_button;

    @FXML
    private Button quit_button;

    @FXML
    void exit(ActionEvent event) throws IOException{
        Stage stg = (Stage) quit_button.getScene().getWindow();
        stg.close();
    }

    @FXML
    void toGame(ActionEvent event) throws IOException {
        Stage stg = (Stage) play_button.getScene().getWindow();
        stg.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Snakes_and_Ladders.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 279, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Snakes and Ladders");
        stage.setScene(scene);
        stage.show();
    }
}