package Environment;

import Game.GamePanel;

/**
 * Created by tristan on 27/09/16.
 */
public class EnvironmentManager extends Thread {
    private GamePanel gamePanel;
    private Map map;

    public EnvironmentManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        map = gamePanel.getMap();
    }

    @Override
    public void run() {
        while (true) {
            map.DropDirtJewelry();
            gamePanel.repaintGame();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
