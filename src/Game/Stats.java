package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

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
        Information information = Information.getInstance();
        g2.drawString("Energie dépensée: " + Integer.toString(information.getEnergy()), 20, 18);
        g2.drawString("Blocs de poussière aspirés: " + Integer.toString(information.getDirt()), 200, 18);
        g2.drawString("Bijoux ramassés: " + Integer.toString(information.getJewelry()), 420, 18);
    }
}
