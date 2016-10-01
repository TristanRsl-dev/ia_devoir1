package Robot;

/**
 * Created by tristan on 26/09/16.
 */

//singleton
public class Information {
    private static Information information;
    private int energy;
    private int dirt;
    private int jewelry;

    private Information(){
        energy = 0;
        dirt = 0;
        jewelry = 0;
    }

    public static Information getInstance(){
        if(null == information){
            information = new Information();
        }
        return information;
    }

    public void incEnergy() {
        energy++;
    }

    public void incDirt() {
        dirt++;
    }

    public void incJewelry() {
        jewelry++;
    }

    public int getEnergy() {
        return energy;
    }

    public int getDirt() { return dirt; }

    public int getJewelry() { return jewelry; }
}
