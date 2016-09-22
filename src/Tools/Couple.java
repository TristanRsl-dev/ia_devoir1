package Tools;

/**
 * Created by tristan on 22/09/16.
 */
public class Couple<X, Y> {
    private X x;
    private Y y;

    public Couple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public void setX(X x) {
        this.x = x;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}
