package tron;


import javax.swing.*;
import java.awt.*;

public class TronFrame extends JFrame {

    public TronFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("John Buttigieg's 2D Tron Legacy Multiplayer Game");


        initalise();

    }


    public void initalise() {
        setLayout(new GridLayout(1, 1, 0, 0));

        Window window = new Window();
        add(window);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();




    }


    public static void main(String[] args) {
        new TronFrame();

    }



}
