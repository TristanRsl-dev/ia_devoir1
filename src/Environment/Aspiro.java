package Environment;

import Tools.Couple;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tristan on 22/09/16.
 */
public class Aspiro {
    private BufferedImage pic;
    private Couple pos;
    private Rectangle box;

    public Aspiro() {
        try {
            pic = ImageIO.read(getClass().getResource("../Resources/aspiro.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pos = new Couple(0, 0);
        box = new Rectangle((int)pos.getX(), (int)pos.getY(), pic.getWidth(), pic.getHeight());
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
}
