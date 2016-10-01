package Game;

import Environment.Map;
import Game.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tristan on 22/09/16.
 */
public class Window extends JFrame {
    public static final int WIDTH = Map.MAPW;
    public static final int HEIGHT = 500;

    public Window(GamePanel gamePanel) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Aspirobot T-0.1");

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(gamePanel);


        //gamePanel.grabFocus();
        //gamePanel.requestFocusInWindow();
        this.setVisible(true);
    }
}
