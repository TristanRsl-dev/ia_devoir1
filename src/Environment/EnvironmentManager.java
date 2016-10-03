package Environment;

import Game.GamePanel;

import java.util.concurrent.locks.ReentrantLock;

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
        ReentrantLock lock = new ReentrantLock();
        while (true) {
            lock.lock();
            map.DropDirtJewelry();
            lock.unlock();
            gamePanel.repaintGame();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
