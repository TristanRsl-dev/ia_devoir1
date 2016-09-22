package Interface;

import javax.swing.*;

/**
 * Created by tristan on 22/09/16.
 */
public class Window extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;

    public Window(GamePanel gamePanel) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Aspirobot T-0.1");
        this.setVisible(true);
        this.setResizable(false);
        this.add(gamePanel);

        gamePanel.grabFocus();
        gamePanel.requestFocusInWindow();
    }
}
