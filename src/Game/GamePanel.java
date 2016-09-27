package Game;

import Environment.Map;
import Robot.Aspiro;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tristan on 22/09/16.
 */
public class GamePanel extends JPanel {
    private Map mapPanel;
    private Stats statPanel;

    public GamePanel() {
        this.setRequestFocusEnabled(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        mapPanel = new Map();
        mapPanel.Parse();
        this.add(mapPanel);
        mapPanel.setLocation(0, 0);

        statPanel = new Stats();
        this.add(statPanel);
        statPanel.setLocation(0, Map.MAPH);
    }

    public void AddAspiro(Aspiro aspiro) {
        mapPanel.AddAspiro(aspiro);
    }

    public void repaintGame() {
        mapPanel.repaint();
        statPanel.repaint();
    }

    public Map getMap() {
        return mapPanel;
    }
}
