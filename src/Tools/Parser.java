package Tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tristan on 26/09/16.
 */
public class Parser {
    private ArrayList<ArrayList> map;

    public Parser() {
        map = new ArrayList<>();
    }

    public ArrayList<ArrayList> parse() {
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource("Resources/map.in").getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                ArrayList tmp = new ArrayList();
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); ++i) {
                    Tile tile;
                    switch (line.charAt(i)) {
                        case 'b':
                            tile = new Tile(TileType.TileTypes.wall);
                            break;
                        case 'd':
                            tile = new Tile(TileType.TileTypes.dirt);
                            break;
                        case 'j':
                            tile = new Tile(TileType.TileTypes.jewelry);
                            break;
                        case 'h':
                            tile = new Tile(TileType.TileTypes.dirtjewelry);
                            break;
                        default:
                            tile = new Tile(TileType.TileTypes.clean);
                            break;
                    }
                    tmp.add(tile);
                }
                map.add(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
