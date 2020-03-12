package observer3;

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
    public void update_pos(int x,int y){

        if (this.get_dis(x,y)<120){

//            System.out.println("warning blue");

            int a=1,b=1;
            if(this.getX()-x<=0){
                a=-1;
            }
            if(this.getY()-y<=0){
                b=-1;
            }

            this.setX(this.getX()+a*30);
            this.setY(this.getY()+b*30);

        }




    }
}
