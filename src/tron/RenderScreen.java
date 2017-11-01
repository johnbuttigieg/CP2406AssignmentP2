package tron;

import java.awt.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderScreen extends JPanel {


        public static int panelColor = 0;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(panelColor));
        g.fillRect(0, 0, 800, 700);
        panelColor++;

        System.out.println("testing");

    }


}
