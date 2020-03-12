package observer3;

import java.awt.*;

public class redBall  extends Ball{

    public redBall( int xSpeed, int ySpeed, int ballSize) {
        super(Color.RED, xSpeed, ySpeed, ballSize);


    }

    public void updatee(Character c){
//        System.out.println("red received");
        int temp = this.getXSpeed();
        this.setXSpeed(this.getYSpeed());
        this.setYSpeed(temp);
    }
    public void update_pos(int x,int y){

        if (this.get_dis(x,y)<100){

           int a=1,b=1;
            if(this.getX()-x<=0){
                a=-1;
            }
            if(this.getY()-y<=0){
                b=-1;
            }

            this.setX(this.getX()+a*50);
            this.setY(this.getY()+b*50);

        }




    }
}
