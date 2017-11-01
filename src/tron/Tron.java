package tron;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;



public class Tron {

    public JFrame jframe;

    public Toolkit javatoolkit;

    public Tron() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("John Buttigieg's 2D Tron");
        jframe.setTitle("John Buttigieg's 2D Tron Legacy Multiplayer Game");
        jframe.setVisible(true);
        jframe.setSize(500,500);
        jframe.setLocation(screen.width / 2 - jframe.getWidth() / 2, screen.height / 2 - jframe.getHeight() / 2);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        javatoolkit = Toolkit.getDefaultToolkit();
    }

    public static void main(String args[]) {
        Tron tron = new Tron();


    }

}
