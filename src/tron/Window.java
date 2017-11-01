package tron;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Window extends JPanel implements Runnable {


    private boolean running = false;
    private Thread thread;


    public static final int WIDTH = 500, HEIGHT = 500;
    private Player p;
    private ArrayList<Player> lightCycle;
    private int xLocation = 20, yLocation = 20;
    private int playerSize = 1;

    private KeyInput key;

    private boolean right = true, left = false, up = false, down = false;

    private int updates = 0;


    public Window() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        key = new KeyInput();
        addKeyListener(key);

        lightCycle = new ArrayList<Player>();

        //leads to start() method to begin the thread to begin the game
        start();

    }


//Starts the thread
    public void start() {
        running = true;
        thread = new Thread(this, "Thread Start");
        thread.start();
    }

    public void stop() {

    }


// inbuilt into JPanel to change graphics of the JPANEL and create the CELLS
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);

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



//this method is run continuously through the run() method below
    public void update() {
        System.out.println("Testing");
        if(lightCycle.size() == 0) {
            p = new Player(xLocation, yLocation, 20);
            lightCycle.add(p);

        }


        updates++;


        if(updates > 90000) {
            if(up) yLocation--;
            if(down) yLocation++;
            if(left) xLocation--;
            if(right) xLocation++;
            updates = 0;

            p = new Player(xLocation, yLocation, 20);
            lightCycle.add(p);

            if (lightCycle.size() > playerSize) {
                lightCycle.remove(0);
            }
        }
    }


// default operation, gets run when thread.start() is initiated
    public void run() {
        while (running) {

            repaint();
            update();
    }
    }


    private class KeyInput implements KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();


                if (key == KeyEvent.VK_RIGHT && !left) {
                    up = false;
                    down = false;
                    right = true;
                }


            if (key == KeyEvent.VK_LEFT && !right) {
                up = false;
                down = false;
                left = true;
            }

            if (key == KeyEvent.VK_UP && !down) {
                up = true;
                right = false;
                left = false;

            }

            if (key == KeyEvent.VK_DOWN && !up) {
                down = true;
                right = false;
                left = false;

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }




}

