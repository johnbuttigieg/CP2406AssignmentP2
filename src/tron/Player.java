package tron;

import java.awt.*;
import java.awt.event.KeyEvent;

class Player {

    boolean active = false;

    //Initial Direction of the player
    private int keyPressed = KeyEvent.VK_RIGHT;

    int getKeyPressed(){
        return this.keyPressed;
    }

    void setKeyPressed(int keyValue){
        this.keyPressed = keyValue;
    }

    Color color1 = Color.blue;

    Color getColor1()
    {
        return this.color1;
    }

    Color color2 = Color.cyan;

    Color getColor2()
    {
        return this.color2;
    }

    //Initial Location of the Player2
     int currentX = 12, currentY = 10;


    Player() {


    }
}
