package Interface;

import Environment.Aspiro;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tristan on 22/09/16.
 */
public class GamePanel extends JPanel {
    private Map mapPanel;

    public GamePanel() {
        this.setRequestFocusEnabled(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        mapPanel = new Map();
        this.add(mapPanel);
        mapPanel.setLocation(0, 0);

        //Ajouter les infos
    }

    public void AddAspiro(Aspiro aspiro) {
        mapPanel.AddAspiro(aspiro);
    }

    public void repaintGame() {
        mapPanel.repaint();
    }
}
