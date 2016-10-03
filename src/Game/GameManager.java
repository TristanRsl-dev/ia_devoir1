package Game;

import Robot.Aspiro;
import Robot.IA;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tristan on 22/09/16.
 */
public class GameManager extends Thread {
    private Aspiro aspiro;
    private GamePanel gamePanel;
    private IA ia;

    public GameManager(GamePanel gamePanel) {
        this.aspiro = Aspiro.GetInstance();
        this.gamePanel = gamePanel;
        this.gamePanel.AddAspiro(aspiro);
        ia = new IA(aspiro);
    }

    @Override
    public void run() {
        int pick;
        int aspir = 0;
        ReentrantLock lock = new ReentrantLock();
        while (true) {
            lock.lock();
            pick = ia.PickUp();
            if (pick != 2)
                aspir = ia.Aspirate();
            if (pick == 0 && aspir == 0)
                ia.Move();
            lock.unlock();
            gamePanel.repaintGame();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
