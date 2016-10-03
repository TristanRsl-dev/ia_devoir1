package Tools;

/**
 * Created by tristan on 27/09/16.
 */
public class Tile {
    private TileType.TileTypes type;
    private int quantity;

    public Tile (TileType.TileTypes type) {
        this.type = type;
        quantity = 0;
    }

    public void setType(TileType.TileTypes type) {
        this.type = type;
    }

    public TileType.TileTypes getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incQuantity() {
        quantity++;
    }

    public void decQuantity() {
        quantity--;
    }
}
