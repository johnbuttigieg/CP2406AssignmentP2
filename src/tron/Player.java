package tron;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public boolean active = false;

    protected int keyPressed = KeyEvent.VK_RIGHT;

    public int getKeyPressed(){
        return this.keyPressed;
    }

    public void setKeyPressed(int keyValue){
        this.keyPressed = keyValue;
    }

    protected Color color1 = Color.blue;

    public Color getColor1()
    {
        return this.color1;
    }

    protected Color color2 = Color.cyan;

    public Color getColor2()
    {
        return this.color2;
    }

    public int
            currentX = 12,
            currentY = 10;


    public Player() {


    }
}
