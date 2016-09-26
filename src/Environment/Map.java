package Environment;

import Game.*;
import Game.Window;
import Robot.Aspiro;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tristan on 22/09/16.
 */
public class Map extends JPanel {
    private Aspiro aspiro;

    public static final int MAPW = 900;
    public static final int MAPH = 400;

    public Map() {
        this.setSize(MAPW, MAPH);
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

        for (int i = 0; i < 20; ++i) {
            g2.drawLine(0, i*aspiro.getBox().height, Window.WIDTH, i*aspiro.getBox().height);
            g2.drawLine(i*aspiro.getBox().width, 0, i*aspiro.getBox().height, Window.HEIGHT);
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(aspiro.getPic(), aspiro.getPosX(), aspiro.getPosY(), null);
    }
}
