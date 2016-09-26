package Game;

import Robot.Aspiro;
import Robot.IA;

/**
 * Created by tristan on 22/09/16.
 */
public class GameManager extends Thread {
    private Aspiro aspiro;
    private GamePanel gamePanel;
    private IA ia;

    public GameManager(GamePanel gamePanel) {
        this.aspiro = new Aspiro();
        this.gamePanel = gamePanel;
        this.gamePanel.AddAspiro(aspiro);
        ia = new IA(aspiro);
    }

    @Override
    public void run() {
        while (true) {
            ia.Move();
            gamePanel.repaintGame();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
