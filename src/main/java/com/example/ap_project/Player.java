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
        //System.out.println(pos);
        for (done=0;done<1;done++){
            if ((pos - (20 * (pos / 20))) == 0 || (pos - (20 * (pos / 20))) == 10) {
                this.move_up();
            } else if ((pos - (20 * (pos / 20))) < 10) {
                this.move_right(1);
            } else {
                this.move_left(1);
            }
        }
        pos++;
    }
    public void ladder_check(){
        if (pos==4){
            pos=25;
            move_blocks(1,2);
        }
        else if (pos==8){
            pos=31;
            move_blocks(2,3);
        }
        else if (pos==28){
            pos=46;
            move_blocks(-2,2);
        }
        else if (pos==21){
            pos=60;
            move_blocks(0,3);
        }
        else if (pos==32){
            pos=48;
            move_blocks(-1,1);
        }
        else if (pos==42){
            pos=80;
            move_blocks(-1,3);
        }
        else if (pos==52){
            pos=68;
            move_blocks(-1,1);
        }
        else if (pos==58){
            pos=77;
            move_blocks(1,2);
        }
        else if (pos==69){
            pos=93;
            move_blocks(-1,3);
        }
        else if (pos==84){
            pos=98;
            move_blocks(-1,1);
        }
    }
    public void snake_check(){
        if (pos==11){
            pos=9;
            move_blocks(-1,-1);
        }
        else if (pos==36){
            pos=14;
            move_blocks(2,-2);
        }
        else if (pos==43){
            pos=22;
            move_blocks(-1,-2);
        }
        else if (pos==56){
            pos=18;
            move_blocks(-2,-4);
        }
        else if (pos==75){
            pos=54;
            move_blocks(1,-2);
        }
        else if (pos==81){
            pos=63;
            move_blocks(2,-2);
        }
        else if (pos==90){
            pos=50;
            move_blocks(0,-4);
        }
        else if (pos==94){
            pos=53;
            move_blocks(1,-4);
        }
        else if (pos==96){
            pos=65;
            move_blocks(0,-3);
        }
        else if (pos==99){
            pos=78;
            move_blocks(1,-2);
        }
    }

    public void move_blocks(int right, int up){
        TranslateTransition ladder=new TranslateTransition(Duration.millis(500),this.id);
        ladder.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        ladder.setByX(25*right);
        ladder.setByY(-36*up);
        ladder.setAutoReverse(false);
        ladder.play();
    }
}
