package tron;

import java.awt.*;

public class Player {

    private int xLocation, yLocation, width, height;

    public Player(int xLocation, int yLocation, int blockSize) {
        width = blockSize;
        height = blockSize;

        this.xLocation = xLocation;
        this.yLocation = yLocation;

    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(xLocation * width, yLocation * height , width, height);
        g.setColor(Color.blue);
        g.fillRect(xLocation * width + 2,yLocation * height + 2, width , height);
    }


    public void update() {


    }






}
