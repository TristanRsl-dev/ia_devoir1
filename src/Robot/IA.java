package Robot;

import Environment.Map;
import Game.GamePanel;
import Tools.Tile;
import Tools.TileType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by tristan on 26/09/16.
 */
public class IA {
    private Aspiro aspiro;
    private ArrayList<ArrayList> map;
    private  Information information;

    public IA(Aspiro aspiro) {
        this.aspiro = aspiro;
        map = Map.getMap();
        information = Information.getInstance();
    }

    public void Move(GamePanel gamePanel) {
        int smallX = aspiro.getPosListx();
        int smallY = aspiro.getPosListy();
        int small = aspiro.getMap()[smallY][smallX];
        int cout = -1;

        for(int y= 0;aspiro.getMap().length>y;y++){
            for (int x= 0;aspiro.getMap()[y].length>x;x++){
                if(0 <= aspiro.getMap()[y][x] && aspiro.getMap()[y][x] <= small){
                    if(aspiro.getMap()[y][x] < small){
                        small = aspiro.getMap()[y][x];
                        smallY = y;
                        smallX = x;
                        cout = (abs(aspiro.getPosListy() - y) + abs(aspiro.getPosListx() - x));
                    }
                    else if(0  > cout || (abs(aspiro.getPosListy() - y) + abs(aspiro.getPosListx() - x)) < cout ){
                        small = aspiro.getMap()[y][x];
                        smallY = y;
                        smallX = x;
                        cout = (abs(aspiro.getPosListy() - y) + abs(aspiro.getPosListx() - x));
                    }
                }
            }
        }

        for(int i=0;(abs(aspiro.getPosListx() - smallX))!=i;i++){
            if(0 > smallX - aspiro.getPosListx()){
                aspiro.Move("left");

            }else{
                aspiro.Move("right");
            }
            gamePanel.repaintGame();
        }

        for(int i=0;(abs(aspiro.getPosListy() - smallY))!=i;i++){
            if(0 > smallY - aspiro.getPosListy()){
                aspiro.Move("up");
            }else{
                aspiro.Move("down");
            }
            gamePanel.repaintGame();
        }

        aspiro.setPosListy(smallY);
        aspiro.setPosListx(smallX);

        aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()] += 1;

    }

    private void FindDirection(String dir) {
        if (dir.equals("left"))
            aspiro.setDir("up");
        else
            aspiro.setDir(Aspiro.Direction.values()[Aspiro.Direction.valueOf(dir).ordinal() + 1].name());
       // Move();
    }

    public int Aspirate() {

        if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.dirt) {
            information.incEnergy();
            information.incDirt();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.clean);
            return 1;
        }
        return 0;
    }

    public int PickUp() {
        if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.dirtjewelry) {
            information.incEnergy();
            information.incJewelry();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.dirt);
            return 2;
        }
        else if (((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).getType()
                == TileType.TileTypes.jewelry) {
            information.incEnergy();
            information.incJewelry();
            ((Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150)).setType(TileType.TileTypes.clean);
            return 1;
        }
        return 0;
    }
}
