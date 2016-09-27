import Environment.EnvironmentManager;
import Game.GameManager;
import Game.GamePanel;
import Game.Window;

/**
 * Created by tristan on 22/09/16.
 */
public class Main {
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();

        GameManager gameManager = new GameManager(gamePanel);
        gameManager.start();

        EnvironmentManager environmentManager = new EnvironmentManager(gamePanel);
        environmentManager.start();

        new Window(gamePanel);
    }
}
