package tron;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Tron implements ActionListener {

    public RenderScreen renderScreen;

    public JFrame jframe;

    public Toolkit javatoolkit;

    public Timer timer = new Timer(20, this);

    public Tron() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("John Buttigieg's 2D Tron");
        jframe.setTitle("John Buttigieg's 2D Tron Legacy Multiplayer Game");
        jframe.setVisible(true);
        jframe.setSize(500,500);
        jframe.setLocation(screen.width / 2 - jframe.getWidth() / 2, screen.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderScreen = new RenderScreen());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer.start();

        javatoolkit = Toolkit.getDefaultToolkit();
    }

    public static void main(String args[]) {
        Tron tron = new Tron();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        renderScreen.repaint();
    }



}
