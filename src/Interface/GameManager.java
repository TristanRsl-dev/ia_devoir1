package Interface;

import Environment.Aspiro;

/**
 * Created by tristan on 22/09/16.
 */
public class GameManager extends Thread {
    private Aspiro aspiro;
    private GamePanel gamePanel;

    public GameManager(GamePanel gamePanel) {
        this.aspiro = new Aspiro();
        this.gamePanel = gamePanel;
        this.gamePanel.AddAspiro(aspiro);
    }

    @Override
    public void run() {
        while (true) {
            gamePanel.repaintGame();
            try {
                Thread.sleep(18);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
