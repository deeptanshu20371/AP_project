package com.example.ap_project;

import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {
    @FXML
    private ImageView id;
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
    public void move(int n){
        int i;
        boolean right;
        int remainder= pos- (20*(pos/20));
        int remaining=n;
        if (remainder==0){
            TranslateTransition up=new TranslateTransition(Duration.millis(500),this.id);
            up.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
            up.setByY(-35);
            up.setAutoReverse(false);
            pos=pos+remaining;
            if (n==1){
                SequentialTransition total= new SequentialTransition(up,snakes_ladder());
                total.play();
                return;
            }
            else{
                remaining--;
                TranslateTransition left=new TranslateTransition(Duration.millis(500),this.id);
                left.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                left.setByX(25*remaining);
                left.setAutoReverse(false);
                SequentialTransition total= new SequentialTransition(up,left,snakes_ladder());
                total.play();
            }
        }
        else if ((remainder)<10){
            right=true;
            TranslateTransition side=new TranslateTransition(Duration.millis(500),this.id);
            side.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));

            if ((10-remainder)<n) {
                side.setByX(25 * (10 - remainder));
                side.setDelay(Duration.millis(500));
                side.setAutoReverse(false);
                remaining=remaining-(10-remainder);
                pos=pos+(10-remainder);
                if (remaining==0){
                    SequentialTransition total= new SequentialTransition(side,snakes_ladder());
                    total.play();
                    return;
                }
                else{
                    TranslateTransition up=new TranslateTransition(Duration.millis(500),this.id);
                    up.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    up.setByY(-35);
                    up.setAutoReverse(false);
                    pos++;
                    remaining--;
                    if (remaining==0){
                        SequentialTransition total= new SequentialTransition(side,up,snakes_ladder());
                        total.play();
                        return;
                    }
                    else{
                        TranslateTransition left=new TranslateTransition(Duration.millis(500),this.id);
                        left.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                        left.setByX(-25*remaining);
                        pos=pos+remaining;
                        SequentialTransition total= new SequentialTransition(side,up,left,snakes_ladder());
                        total.play();
                    }
                }
            }
            else{
                side.setByX(25 * remaining);
                pos=pos+remaining;
                SequentialTransition total=new SequentialTransition(side,snakes_ladder());
                total.play();
            }
        }
        else if ((remainder)>10){
            right=false;
            TranslateTransition side=new TranslateTransition(Duration.millis(500),this.id);
            side.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));

            if ((20-remainder)<n) {
                side.setByX(-25 * (20 - remainder));
                side.setDelay(Duration.millis(500));
                side.setAutoReverse(false);
                remaining=remaining-(20-remainder);
                pos=pos+(20-remainder);
                if (remaining==0){
                    SequentialTransition total=new SequentialTransition(side,snakes_ladder());
                    total.play();
                    return;
                }
                else{
                    TranslateTransition up=new TranslateTransition(Duration.millis(500),this.id);
                    up.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    up.setByY(-35);
                    up.setAutoReverse(false);
                    pos++;
                    remaining--;
                    if (remaining==0){
                        SequentialTransition total= new SequentialTransition(side,up,snakes_ladder());
                        total.play();
                        return;
                    }
                    else{
                        TranslateTransition left=new TranslateTransition(Duration.millis(500),this.id);
                        left.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                        left.setByX(25*remaining);
                        left.setAutoReverse(false);
                        pos=pos+remaining;
                        SequentialTransition total= new SequentialTransition(side,up,left,snakes_ladder());
                        total.play();
                    }
                }
            }
            else{
                side.setByX(-25 * remaining);
                side.setAutoReverse(false);
                pos=pos+remaining;
                SequentialTransition total= new SequentialTransition(side,snakes_ladder());
                total.play();
            }
        }
        else{
            TranslateTransition up=new TranslateTransition(Duration.millis(500),this.id);
            up.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
            up.setByY(-35);
            up.setAutoReverse(false);
            pos=pos+n;
            if (n==1){
                SequentialTransition total = new SequentialTransition(up,snakes_ladder());
                total.play();
            }
            else{
                n=n-1;
                TranslateTransition left=new TranslateTransition(Duration.millis(500),this.id);
                left.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                left.setByX(-25*remaining);
                left.setAutoReverse(false);
                SequentialTransition total= new SequentialTransition(up,left,snakes_ladder());
                total.play();
            }
        }
    }

    private TranslateTransition snakes_ladder(){
        if (pos==4){
            pos=25;
            return move_blocks(1,2);
        }
        else if (pos==8){
            pos=31;
            return move_blocks(2,3);
        }
        else if (pos==28){
            pos=46;
            return move_blocks(-2,2);
        }
        else if (pos==21){
            pos=60;
            return move_blocks(0,3);
        }
        else if (pos==32){
            pos=48;
            return move_blocks(-1,1);
        }
        else if (pos==42){
            pos=80;
            return move_blocks(-1,3);
        }
        else if (pos==52){
            pos=68;
            return move_blocks(-1,1);
        }
        else if (pos==58){
            pos=77;
            return move_blocks(1,2);
        }
        else if (pos==69){
            pos=93;
            return move_blocks(-1,3);
        }
        else if (pos==84){
            pos=98;
            return move_blocks(-1,1);
        }
        else if (pos==11){
            pos=9;
            return move_blocks(-1,-1);
        }
        else if (pos==36){
            pos=14;
            return move_blocks(2,-2);
        }
        else if (pos==43){
            pos=22;
            return move_blocks(-1,-2);
        }
        else if (pos==56){
            pos=18;
            return move_blocks(-2,-4);
        }
        else if (pos==75){
            pos=54;
            return move_blocks(1,-2);
        }
        else if (pos==81){
            pos=63;
            return move_blocks(2,-2);
        }
        else if (pos==90){
            pos=50;
            return move_blocks(0,-4);
        }
        else if (pos==94){
            pos=53;
            return move_blocks(1,-4);
        }
        else if (pos==96){
            pos=65;
            return move_blocks(0,-3);
        }
        else if (pos==99){
            pos=78;
            return move_blocks(1,-2);
        }
        else{
            return move_blocks(0,0);
        }
    }

    private TranslateTransition move_blocks(int right, int up){
        TranslateTransition ladder=new TranslateTransition(Duration.millis(500),this.id);
        ladder.setByX(25*right);
        ladder.setByY(-36*up);
        ladder.setAutoReverse(false);
        return ladder;
    }
}