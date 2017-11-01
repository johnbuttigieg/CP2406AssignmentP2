package tron;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JPanel implements Runnable {


    private boolean running = false;
    private Thread thread;


    public static final int WIDTH = 500, HEIGHT = 500;
    private Player p;
    private ArrayList<Player> lightCycle;
    private int xLocation = 20, yLocation = 20;


    public Window() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        lightCycle = new ArrayList<Player>();

        start();

    }



    public void start() {
        running = true;
        thread = new Thread(this, "Thread Start");
        thread.start();
    }

    public void stop() {

    }


// inbuilt into JPanel to change graphics of the JPANEL
    public void paint(Graphics g) {
        for (int i = 0; i < WIDTH / 20; i++) {
            g.drawLine(i * 20, 0 , i * 20, HEIGHT);
        }

        for (int  i = 0; i < HEIGHT / 20; i++) {
            g.drawLine(0, i * 20, WIDTH, i * 20);
        }
    }


    public void update() {
        System.out.println("Testing");
    }

    public void run() {
        while (running) {

            repaint();
            update();
    }







    }





}

