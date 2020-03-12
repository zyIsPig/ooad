package observer2;

import java.awt.*;

public class redBall  extends Ball{

    public redBall( int xSpeed, int ySpeed, int ballSize) {
        super(Color.RED, xSpeed, ySpeed, ballSize);


    }

    public void updatee(Character c){
        System.out.println("red received");
        int temp = this.getXSpeed();
        this.setXSpeed(this.getYSpeed());
        this.setYSpeed(temp);
    }
}
