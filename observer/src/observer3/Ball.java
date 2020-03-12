package observer3;

import java.awt.*;
import java.util.ArrayList;

public class Ball {
    private Color color;
    private int x, y;
    private int xSpeed, ySpeed;
    private int ballSize;
    private boolean visible;
    private ArrayList<Ball> ballList=new ArrayList<>();

    public boolean isPosition_changed() {
        return position_changed;
    }

    public void setPosition_changed(boolean position_changed) {
        this.position_changed = position_changed;
    }

    private boolean position_changed=false;

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    private boolean changed=false;

    public Ball(Color color, int xSpeed, int ySpeed, int ballSize) {
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.ballSize = ballSize;

        this.visible = true;
        this.x = (int) (Math.random() * 600);
        this.y = (int) (Math.random() * 600);
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public Color getColor() {
        return this.color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getBallSize() {
        return ballSize;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void draw(Graphics g) {
        if (isVisible()) {
            g.setColor(this.getColor());
            g.fillOval(this.getX(), this.getY(), this.getBallSize(), this.getBallSize());
        }
    }

    public void move() {
//        System.out.println("move ball");
        int newX = this.getX() + this.getXSpeed();
        int newY = this.getY() + this.getYSpeed();

        this.notify_ball(newX,newY);
        this.setX(newX);
        this.setY(newY);

        if (newX <= 0) {
            this.setXSpeed(Math.abs(getXSpeed()));
        } else if (newX >= 600 - this.getBallSize()) {
            this.setXSpeed(-1 * Math.abs(getXSpeed()));
        }

        if (newY <= 0) {
            this.setYSpeed(Math.abs(getYSpeed()));
        } else if (newY > 600 - this.getBallSize()) {
            this.setYSpeed(-1 * Math.abs(getYSpeed()));
        }
    }

    public boolean isIntersect(Ball ball) {
        int diffX = this.getX() - ball.getX();
        int diffY = this.getY() - ball.getY();
        double dis = (this.getBallSize() + ball.getBallSize()) / 2.0;

        return (diffX * diffX) + (diffY * diffY) < dis * dis;
    }


    public void updatee(Character c){
//        System.out.println("we received the update message");
    }


    public void register(Ball ball){
        this.ballList.add(ball);
    }

    public void remove(Ball ball){
        this.ballList.remove(ball);
    }

    public void notify_ball(int x,int y){
        for(Ball b:ballList){

            if(!b.isPosition_changed()){
                b.update_pos(x,y);
                b.setPosition_changed(false);
            }



        }
    }
    public void update_pos(int x,int y){


//        System.out.println("aaa"+this.color+"x:"+x+"y:"+y);
    }


    public double get_dis(int x,int y){

        double a=Math.pow(Math.abs(this.getX()-x),2);
        double b=Math.pow(Math.abs(this.getY()-y),2);

        return Math.pow(a+b,0.5);
    }

}

