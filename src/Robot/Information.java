package Robot;

/**
 * Created by tristan on 26/09/16.
 */
public class Information {
    private static int energy = 0;

    public static void incEnergy() {
        energy++;
    }

    public static int getEnergy() {
        return energy;
    }
}
