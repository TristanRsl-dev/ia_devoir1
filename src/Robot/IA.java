package Robot;

import Environment.Map;
import Game.GamePanel;

import Tools.Couple;
import Tools.Tile;
import Tools.TileType;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void Move() {
        int smallX = aspiro.getPosListx();
        int smallY = aspiro.getPosListy();
        int small = aspiro.getMap()[smallY][smallX];
        int cout = -1;

        //on recherche la case ayant le plus petit nombre de visite

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

        //on a une cible avec la plus petite valeur de visite on souhaite y aller en passant par les case voisines
        //ayant egalement la plus faible valeur visite;

        String direction = "";
        int values = Integer.MAX_VALUE;

        for(int i=0;(abs(aspiro.getPosListy() - smallY))!=i;i++){
            if(0 > smallY - aspiro.getPosListy()){
                if(aspiro.getMap()[aspiro.getPosListy()-1][aspiro.getPosListx()] == -1){
                    break;
                }
                values = aspiro.getMap()[aspiro.getPosListy()-1][aspiro.getPosListx()];
                direction = "up";
                smallX = aspiro.getPosListx();
                smallY = aspiro.getPosListy()-1;
                break;
            }else{
                if(aspiro.getMap()[aspiro.getPosListy()+1][aspiro.getPosListx()] == -1){
                    break;
                }
                values = aspiro.getMap()[aspiro.getPosListy()+1][aspiro.getPosListx()];
                direction = "down";
                smallX = aspiro.getPosListx();
                smallY = aspiro.getPosListy()+1;
                break;
            }
        }

        for(int i=0;(abs(aspiro.getPosListx() - smallX))!=i;i++){
            if(0 > smallX - aspiro.getPosListx()){
                if(aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()-1] != -1 &&
                        values >= aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()-1]){
                    values = aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()-1];
                    direction = "left";
                    smallX = aspiro.getPosListx()-1;
                    smallY = aspiro.getPosListy();
                }
                break;
            }else{
                if(aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()+1] != -1 &&
                        values >= aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()+1]){
                    values = aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()+1];
                    direction = "right";
                    smallX = aspiro.getPosListx()+1;
                    smallY = aspiro.getPosListy();
                }
                break;
            }

        }

        if(!direction.equals("")) {
            aspiro.Move(direction);
        }
        aspiro.setPosListy(smallY);
        aspiro.setPosListx(smallX);

        aspiro.getMap()[aspiro.getPosListy()][aspiro.getPosListx()] += 1;
        //peut etre +2 pour la case du fond
    }

    private void FindDirection(String dir) {
        if (dir.equals("left"))
            aspiro.setDir("up");
        else
            aspiro.setDir(Aspiro.Direction.values()[Aspiro.Direction.valueOf(dir).ordinal() + 1].name());
       // Move();
    }

    public int Aspirate() {
        Tile tile = (Tile)map.get(aspiro.getPosY() / 150).get(aspiro.getPosX() / 150);
        if (tile.getType()
                == TileType.TileTypes.dirt) {
            information.incEnergy();
            information.incDirt();
            tile.decQuantity();
            if (tile.getQuantity() == 0)
                tile.setType(TileType.TileTypes.clean);
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
