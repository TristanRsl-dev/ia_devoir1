package Robot;

/**
 * Created by tristan on 26/09/16.
 */
public class Information {
    private static int energy = 0;
    private static int dirt = 0;
    private static int jewelry = 0;

    public static void incEnergy() {
        energy++;
    }

    public static void incDirt() {
        dirt++;
    }

    public static void incJewelry() {
        jewelry++;
    }

    public static int getEnergy() {
        return energy;
    }

    public static int getDirt() { return dirt; }

    public static int getJewelry() { return jewelry; }
}
