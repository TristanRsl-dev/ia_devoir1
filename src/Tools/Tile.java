package Tools;

/**
 * Created by tristan on 27/09/16.
 */
public class Tile {
    private TileType.TileTypes type;

    public Tile (TileType.TileTypes type) {
        this.type = type;
    }

    public void setType(TileType.TileTypes type) {
        this.type = type;
    }

    public TileType.TileTypes getType() {
        return type;
    }
}
