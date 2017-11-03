package tron;


import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }


    private Main() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("John Buttigieg's 2D Tron Legacy Multiplayer Game");


        initalise();

    }


    private void initalise() {
        setLayout(new GridLayout(1, 1, 0, 0));

        Window window = new Window();
        add(window);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();


    }






}
