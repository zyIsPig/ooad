package observer3;

import java.awt.*;

public class greenBall extends Ball {


    public greenBall(int xSpeed, int ySpeed, int ballSize) {
        super(Color.GREEN, xSpeed, ySpeed, ballSize);
    }

    public void print_green_ball(){
        System.out.println(this.getColor());
    }

    public void updatee(Character c){

//        System.out.println("green received");
        switch (c){

            case 'a':
                this.setXSpeed(-Math.abs(this.getXSpeed()));
                break;
            case 'd':
                this.setXSpeed(Math.abs(this.getXSpeed()));
                break;
            case 'w':
                this.setYSpeed(-Math.abs(this.getYSpeed()));
                break;
            case 's':
                this.setYSpeed(Math.abs(this.getYSpeed()));



        }
    }
}
