package observer3;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel implements KeyListener {

    private List<Ball> paintingBallList = new ArrayList<>();
    private boolean start = false;
    private int score = 0;
    private observer3.redBall redBall;
    private observer3.greenBall greenBall;
    private observer3.blueBall blueBall;
    private List<Ball> list=new ArrayList<>();

    public MainPanel() {
//        redBall=new redBall(3,10,50);
        redBall=new redBall(3,10,50);
        this.register(redBall);
//        redBall = new Ball(Color.RED, 3, 10, 50);
//        greenBall = new Ball(Color.GREEN, 5, 7, 100);
        greenBall =new greenBall(5,7,100);

        this.register(greenBall);
        blueBall=new blueBall(8,10,80);

        this.register(blueBall);
//        blueBall = new Ball(Color.BLUE, 8, 10, 80);
        paintingBallList.add(redBall);
        paintingBallList.add(greenBall);
        paintingBallList.add(blueBall);

        greenBall.register(redBall);
        greenBall.register(blueBall);
        redBall.register(greenBall);
        greenBall.register(redBall);
        this.addKeyListener(this);

        // WHAT GOES HERE?
        // You need to make it possible for the app to get the keyboard values.
        setFocusable(true);
        setPreferredSize(new Dimension(600, 600));

        System.out.println("here we go");

        Timer t = new Timer(20, e -> moveBalls());
        t.start();
    }

    public void registerObserver(){

    }

    public void setPaintingBallList(List<Ball> paintingBallList) {
        this.paintingBallList = paintingBallList;
    }

    public void moveBalls() {
//        System.out.println("akjshshshshhshs");
        for (Ball b : paintingBallList) {
//            System.out.println("laojsojs");
            b.move();
        }

        // collision detection
        for (int i = 0; start && i < paintingBallList.size() - 1; i++) {
            if (paintingBallList.get(i).isVisible()) {
                for (int j = i+1; j < paintingBallList.size(); j++) {
                    Ball ball = paintingBallList.get(j);
                    if (ball.isVisible() && paintingBallList.get(i).isIntersect(ball)) {
                        ball.setVisible(false);
                        paintingBallList.get(i).setVisible(false);
                    }
                }
            }
        }

        repaint();
    }
//
    public void register(Ball ball){
        this.list.add(ball);



    }


    public void remove(Ball ball){
        this.list.remove(ball);
    }

    public void notifiy(List<Ball> list,Character c){
        for (Ball b:list){
            if(b.isChanged()) {
                b.updatee(c);
                b.setChanged(false);
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int visibleNum = 0;
        for (Ball b : paintingBallList) {
            if (b.isVisible()) {
                b.draw(g);
                visibleNum++;
            }
        }

        if (visibleNum <= 1) {
            g.setFont(new Font("Arial", Font.PLAIN, 75));
            for (int i = 70; i < 600; i += 100) {
                g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
                g.drawString("Game Over!", 100, i);
            }
        } else if (start) {
            score += visibleNum;
        }

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 20, 40);

        this.setBackground(Color.WHITE);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {


        char keyChar = keyEvent.getKeyChar();
//        System.out.println(keyChar+"pressed");

//        this.notifiy(list,keyChar);



        if (keyChar == ' ') {
            System.out.println();
            start = !start;
        }
////
//        if (keyChar == 'a' || keyChar == 'd') {
//            redBall.setChanged(true);
//
////            int temp = redBall.getXSpeed();
////            redBall.setXSpeed(redBall.getYSpeed());
////            redBall.setYSpeed(temp);
//        }



//
        switch (keyChar) {
            case 'a':
                redBall.setChanged(true);
                greenBall.setChanged(true);
                break;
            case 'd':
                redBall.setChanged(true);
                greenBall.setChanged(true);
                break;
            case 'w':
                greenBall.setChanged(true);
                break;
            case 's':
                greenBall.setChanged(true);
                break;
        }
        blueBall.setChanged(true);
        this.notifiy(list,keyChar);

//
//        blueBall.setXSpeed(-1 * blueBall.getXSpeed());
//        blueBall.setYSpeed(-1 * blueBall.getYSpeed());
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
