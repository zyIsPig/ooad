package observer2;

import java.awt.*;

public class blueBall extends Ball {

    public blueBall( int xSpeed, int ySpeed, int ballSize) {
        super(Color.BLUE, xSpeed, ySpeed, ballSize);
    }

    public void updatee(Character c){
        System.out.println("blue received");
        this.setXSpeed(-1 * this.getXSpeed());
        this.setYSpeed(-1 * this.getYSpeed());
    }
}
