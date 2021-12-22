package com.example.ap_project;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Game implements Initializable {
    private int dice_num;
    private Parent root;
    private int random;
    @FXML
    private Button back_button;
    @FXML
    ImageView player1;
    @FXML
    ImageView player2;
    @FXML
    ImageView p1_indicator;
    @FXML
    ImageView p2_indicator;
    Player p1;
    Player p2;
    Player curr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1= new Player(player1,1);
        p2= new Player(player2,2);
        curr=p1;
    }

    @FXML
    void go_back(ActionEvent event) throws IOException {
        Stage stg = (Stage) back_button.getScene().getWindow();
        stg.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Snakes and Ladders");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void dice_roll(ActionEvent roll) throws IOException{
        random=(int)(Math.random()*6)+1;
        if (curr.first_roll){
            curr.start();
            curr.first_roll=false;
        }
        else{
            curr.move(random);
            curr.ladder_check();
            curr.snake_check();
        }
        if (curr== p1){
            curr=p2;
            //p1_indicator.setImage(new Image("@p1_off.jpeg"));
            //p2_indicator.setImage(new Image("@Player2_button.jpeg"));
        }
        else{
            curr=p1;
            //p1_indicator.setImage(new Image("@Player1_button.jpeg"));
            //p2_indicator.setImage(new Image("@p2_off.jpeg"));
        }
    }

}