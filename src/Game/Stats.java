package Game;

import javax.swing.*;
import java.awt.*;

import Environment.Map;
import Robot.Information;

/**
 * Created by tristan on 26/09/16.
 */
public class Stats extends JPanel {
    public Stats() {
        this.setSize(Map.MAPW, 50);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawString("Energie dépensée: " + Integer.toString(Information.getEnergy()), 20, 15);
        g2.drawString("Blocs de poussière aspirés: " + Integer.toString(Information.getDirt()), 200, 15);
        g2.drawString("Bijoux ramassés: " + Integer.toString(Information.getJewelry()), 420, 15);
    }
}
