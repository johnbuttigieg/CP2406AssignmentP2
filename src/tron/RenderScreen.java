package tron;

import java.awt.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderScreen extends JPanel {


        public static Color black = new Color(350000);


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 700);

        System.out.println("testing");

    }


}
