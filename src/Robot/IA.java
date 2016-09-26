package Robot;

import Environment.Map;

/**
 * Created by tristan on 26/09/16.
 */
public class IA {
    private Aspiro aspiro;

    public IA(Aspiro aspiro) {
        this.aspiro = aspiro;
    }

    public void Move() {
        switch (aspiro.getDir()) {
            case "up":
                if (aspiro.getPosY() - aspiro.getBox().getHeight() >= 0)
                    aspiro.Move("up");
                else
                    FindDirection("up");
                break;
            case "right":
                if (aspiro.getPosX() + aspiro.getBox().getWidth() < Map.MAPW)
                    aspiro.Move("right");
                else
                    FindDirection("right");
                break;
            case "down":
                if (aspiro.getPosY() + aspiro.getBox().getHeight() < Map.MAPH)
                    aspiro.Move("down");
                else
                    FindDirection("down");
                break;
            default:
                if (aspiro.getPosX() - aspiro.getBox().getWidth() >= 0)
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

    public void Aspirate() {

    }

    public void PickUp() {

    }
}
