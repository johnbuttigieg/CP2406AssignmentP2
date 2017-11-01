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
    private int playerSize = 5;


    private boolean right = true, left = false, up = false, down = false;

    private int updates = 0;


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
        g.setColor(Color.black);
        for (int i = 0; i < WIDTH / 20; i++) {
            g.drawLine(i * 20, 0, i * 20, HEIGHT);
        }

        for (int i = 0; i < HEIGHT / 20; i++) {
            g.drawLine(0, i * 20, WIDTH, i * 20);
        }

        for (int i = 0; i < lightCycle.size(); i++)
        {
            lightCycle.get(i).draw(g);
        }

    }




    public void update() {
        System.out.println("Testing");
        if(lightCycle.size() == 0) {
            p = new Player(xLocation, yLocation, 20);
            lightCycle.add(p);

        }


        updates++;

        if(updates > 30000) {
            if(up) yLocation--;
            if(down) yLocation++;
            if(left) xLocation--;
            if(right) xLocation++;
            updates = 0;

            
        }
    }

    public void run() {
        while (running) {

            repaint();
            update();
    }







    }





}

