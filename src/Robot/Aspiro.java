package Robot;

import Tools.Couple;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

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
    private String direction;
    private int[][] map;
    private int posListx;
    private int posListy;

    public enum Direction {
        up,
        right,
        down,
        left
    }



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
        map = new int[3][5];
        instanciateMap();
        posListx = 0;
        posListy = 0;

    }

    private void instanciateMap() {
        //on cree un tableau de tableau contenant la map
        // on affecte un valeur de visite initialiser a 0 et sera incrementer a chaque visite de l'aspirateur
        for(int i= 0;map.length>i;i++){
            for (int y= 0;map[i].length>y;y++){
                if((0==i || 2==i) && (3==y || 4==y)){
                    map[i][y]= -1;
                }else {
                    map[i][y] = 0;
                }
            }
        }
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

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getPosListx() {
        return posListx;
    }

    public void setPosListx(int posListx) {
        this.posListx = posListx;
    }

    public int getPosListy() {
        return posListy;
    }

    public void setPosListy(int posListy) {
        this.posListy = posListy;
    }
}
