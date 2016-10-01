package Robot;

import Tools.Couple;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tristan on 22/09/16.
 */
//singleton

public class Aspiro {
    private static Aspiro aspiro;
    private BufferedImage pic;
    private Couple pos;
    private Rectangle box;
    private Information information;

    public enum Direction {
        up,
        right,
        down,
        left
    }

    private String direction;

    public static Aspiro GetInstance(){
        if(null == aspiro){
            aspiro = new Aspiro();
        }
        return aspiro;
    }

    private Aspiro() {
        try {
            pic = ImageIO.read(getClass().getResource("../Resources/aspiro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pos = new Couple(0, 0);
        box = new Rectangle((int)pos.getX(), (int)pos.getY(), pic.getWidth(), pic.getHeight());
        direction = Direction.right.name();
        information = Information.getInstance();
    }

    public BufferedImage getPic() {
        return pic;
    }

    public int getPosX() {
        return (int)pos.getX();
    }

    public int getPosY() {
        return (int)pos.getY();
    }

    public Rectangle getBox() {
        return box;
    }

    public void Move(String dir) {
        switch (dir) {
            case "up":
                pos.setY((int)pos.getY() - (int)box.getHeight());
                direction = Direction.up.name();
                break;
            case "right":
                pos.setX((int)pos.getX() + (int)box.getWidth());
                direction = Direction.right.name();
                break;
            case "down":
                pos.setY((int)pos.getY() + (int)box.getHeight());
                direction = Direction.down.name();
                break;
            default:
                pos.setX((int)pos.getX() - (int)box.getWidth());
                direction = Direction.left.name();
                break;
        }
        information.incEnergy();
    }

    public String getDir() {
        return direction;
    }

    public void setDir(String direction) {
        this.direction = direction;
    }
}
