package Environment;

import Game.Window;
import Robot.Aspiro;
import Tools.Parser;
import Tools.Tile;
import Tools.TileType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tristan on 22/09/16.
 */
public class Map extends JPanel {
    private Aspiro aspiro;
    private Parser parser;
    private static ArrayList<ArrayList> list;
    private ArrayList tiles_pics;

    public static final int MAPW = 750;
    public static final int MAPH = 450;

    public Map() {
        this.setSize(MAPW, MAPH);
        this.setBackground(Color.PINK);
        this.setLayout(null);
        this.setDoubleBuffered(true);

        parser = new Parser();
        tiles_pics = new ArrayList();
        LoadPic();
    }

    public void AddAspiro(Aspiro aspiro) {
        this.aspiro = aspiro;
    }

    public void Parse() {
        list = parser.parse();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < 5; ++i) {
            g2.drawLine(0, i*aspiro.getBox().height, Window.WIDTH, i*aspiro.getBox().height);
            g2.drawLine(i*aspiro.getBox().width, 0, i*aspiro.getBox().width, Window.HEIGHT);
        }

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.wall) {
                    for (int k = 0; k < 150; ++k)
                        g2.drawLine(i*aspiro.getBox().width + k, j*aspiro.getBox().height,
                                i*aspiro.getBox().width + k, (j + 1)*aspiro.getBox().height);
                }
                else if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.dirt) {
                    g2.drawImage((BufferedImage)tiles_pics.get(0), i*aspiro.getBox().width,
                            j*aspiro.getBox().height, null);
                }
                else if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.jewelry) {
                    g2.drawImage((BufferedImage)tiles_pics.get(1), i*aspiro.getBox().width,
                            j*aspiro.getBox().height, null);
                }
                else if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.dirtjewelry) {
                    g2.drawImage((BufferedImage)tiles_pics.get(0), i*aspiro.getBox().width,
                            j*aspiro.getBox().height, null);
                    g2.drawImage((BufferedImage)tiles_pics.get(1), i*aspiro.getBox().width,
                            j*aspiro.getBox().height, null);
                }
            }
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(aspiro.getPic(), aspiro.getPosX(), aspiro.getPosY(), null);
    }

    public static ArrayList<ArrayList> getMap() {
        return list;
    }

    private void LoadPic() {
        try {
            tiles_pics.add(ImageIO.read(getClass().getResource("../Resources/tile_dirt.png")));
            tiles_pics.add(ImageIO.read(getClass().getResource("../Resources/tile_jewelry.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DropDirtJewelry() {
        Random random = new Random();
        int i = random.nextInt(5);
        int j = random.nextInt(3);
        int jord = random.nextInt();
        if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.wall)
            DropDirtJewelry();
        else {
            if (jord % 15 == 0) {
                if (((Tile)list.get(j).get(i)).getType() == TileType.TileTypes.dirt)
                    ((Tile) list.get(j).get(i)).setType(TileType.TileTypes.dirtjewelry);
                else
                    ((Tile) list.get(j).get(i)).setType(TileType.TileTypes.jewelry);
            }
            else {
                if (((Tile) list.get(j).get(i)).getType() == TileType.TileTypes.jewelry)
                    ((Tile) list.get(j).get(i)).setType(TileType.TileTypes.dirtjewelry);
                else
                    ((Tile) list.get(j).get(i)).setType(TileType.TileTypes.dirt);
            }

        }
    }
}
