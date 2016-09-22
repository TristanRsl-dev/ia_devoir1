package Interface;

import Environment.Aspiro;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tristan on 22/09/16.
 */
public class Map extends JPanel {
    private Aspiro aspiro;

    public Map() {
        this.setSize(900, 400);
        this.setBackground(Color.PINK);
        this.setLayout(null);
        this.setDoubleBuffered(true);
    }

    public void AddAspiro(Aspiro aspiro) {
        this.aspiro = aspiro;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(aspiro.getPic(), aspiro.getPosX(), aspiro.getPosY(), null);
    }
}
