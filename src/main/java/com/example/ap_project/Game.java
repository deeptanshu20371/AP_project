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

import java.io.File;
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
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private ImageView p1_indicator;
    @FXML
    private ImageView p2_indicator;
    private Player p1;
    private Player p2;
    private Player curr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1= new Player(player1,1);
        p2= new Player(player2,2);
        curr=p1;
    }

    @FXML
    private void go_back(ActionEvent event) throws IOException {
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
        System.out.println("random "+random);
        if (!curr.first_roll){
            if (curr.pos>=94) {
                if ((100-curr.pos)>random) {
                    curr.move(random);
                }
                if ((100-curr.pos)==random){
                    curr.move(random);
                    if(curr.num == 2){
                        System.out.println("winner ooga booga");
                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("winner2.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 280, 600);
                        Stage stage = new Stage();
                        stage.setTitle("Winner");
                        stage.setScene(scene);
                        stage.show();
                        System.out.println("winner ooga booga");
                    } else{
                        System.out.println("winner ooga booga");
                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("winner1.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 280, 600);
                        Stage stage = new Stage();
                        stage.setTitle("Winner");
                        stage.setScene(scene);
                        stage.show();
                        System.out.println("winner ooga booga");
                    }
                }
            }
            else{
                curr.move(random);
            }
        }
        else if (random==1){
            curr.start();
            curr.first_roll = false;
        }
        if (curr== p1){
            curr=p2;
            p1_indicator.setImage(new Image(new File("p1_off.jpeg").toURI().toString()));
            p2_indicator.setImage(new Image(new File("Player2_button.jpeg").toURI().toString()));
        }
        else{
            curr=p1;
            p1_indicator.setImage(new Image(new File("Player1_button.jpeg").toURI().toString()));
            p2_indicator.setImage(new Image(new File("p2_off.jpeg").toURI().toString()));
        }
    }

}