package tron;

import java.awt.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0));
        g.fillRect(0, 0, 800, 700);
        super.paintComponent(g);

    }


}
