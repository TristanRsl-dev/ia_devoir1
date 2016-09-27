package Robot;

import Environment.Map;
import Tools.Tile;
import Tools.TileType;

import java.util.ArrayList;

/**
 * Created by tristan on 26/09/16.
 */
public class IA {
    private Aspiro aspiro;
    private ArrayList<ArrayList> map;

    public IA(Aspiro aspiro) {
        this.aspiro = aspiro;
        map = Map.getMap();
    }

    public void Move() {
        switch (aspiro.getDir()) {
            case "up":
                int newpos = aspiro.getPosY() - (int)aspiro.getBox().getHeight();
                if (newpos >= 0 && ((Tile)map.get(newpos / 150).get(aspiro.getPosX() / 150)).getType()
                        != TileType.TileTypes.wall)
                    aspiro.Move("up");
                else
                    FindDirection("up");
                break;
            case "right":
                newpos = aspiro.getPosX() + (int)aspiro.getBox().getWidth();
                if (newpos < Map.MAPW && ((Tile)map.get(aspiro.getPosY() / 150).get(newpos / 150)).getType()
                        != TileType.TileTypes.wall)
                    aspiro.Move("right");
                else
                    FindDirection("right");
                break;
            case "down":
                newpos = aspiro.getPosY() + (int)aspiro.getBox().getHeight();
                if (newpos < Map.MAPH && ((Tile)map.get(newpos / 150).get(aspiro.getPosX() / 150)).getType()
                        != TileType.TileTypes.wall)
                    aspiro.Move("down");
                else
                    FindDirection("down");
                break;
            default:
                newpos = aspiro.getPosX() - (int)aspiro.getBox().getWidth();
                if (newpos >= 0 && ((Tile)map.get(aspiro.getPosY() / 150).get(newpos / 150)).getType()
                        != TileType.TileTypes.wall)
                    aspiro.Move("left");
                else
                    FindDirection("left");
                break;
        }
    }

    private void FindDirection(String dir) {
        if (dir.equals("left"))
            aspiro.setDir("up");
        else
            aspiro.setDir(Aspiro.Direction.values()[Aspiro.Direction.valueOf(dir).ordinal() + 1].name());
        Move();
    }

    public int Aspirate() {
        if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.dirt) {
            Information.incEnergy();
            Information.incDirt();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.clean);
            return 1;
        }
        return 0;
    }

    public int PickUp() {
        if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.dirtjewelry) {
            Information.incEnergy();
            Information.incJewelry();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.dirt);
            return 2;
        }
        else if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.jewelry) {
            Information.incEnergy();
            Information.incJewelry();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.clean);
            return 1;
        }
        return 0;
    }
}
