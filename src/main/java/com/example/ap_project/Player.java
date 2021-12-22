package com.example.ap_project;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {
    @FXML
    final ImageView id;
    int pos;
    int num;
    boolean first_roll;
    public Player(ImageView id,int num){
        this.id=id;
        this.num=num;
        this.first_roll=true;
    }
    public void start(){
        if (num==1) {
            id.setTranslateX(-9);
            id.setTranslateY(-27);
        }
        else{
            id.setTranslateX(7);
            id.setTranslateY(-27);
        }
        pos=1;
    }
    public void move_right(int num) {
        TranslateTransition side=new TranslateTransition(Duration.millis(500),this.id);
        side.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        side.setByX(25*num);
        side.setAutoReverse(false);
        side.play();
    }
    public void move_left(int num) {
        TranslateTransition left=new TranslateTransition(Duration.millis(500),this.id);
        left.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        left.setByX(-25*num);
        left.setAutoReverse(false);
        left.play();
    }
    public void move_up() {
        TranslateTransition up=new TranslateTransition(Duration.millis(500),this.id);
        up.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        up.setByY(-36);
        up.setAutoReverse(false);
        up.play();
    }
    public void move(int n){
        int done;
        for (done=0;done<n;done++){
            Thread thread= new Thread(()->{
                if ((pos - (20 * (pos / 20))) == 0 || (pos - (20 * (pos / 20))) == 10) {
                    this.move_up();
                } else if ((pos - (20 * (pos / 20))) < 10) {
                    this.move_right(1);
                } else {
                    this.move_left(1);
                }
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

        pos++;
    }
}
