package animal;

import location.Location;
import resources.AnimalSetting;
import resources.SimulationSetting;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    public abstract AnimalSetting getBaseSetting();
    public final Object[] move(Location location, int maxMoves){
        int coordX = location.getCoordX();
        int coordY = location.getCoordY();

        return chooseDirection(coordX, coordY, maxMoves);
    }
    private Object[] chooseDirection(int coordX, int coordY, int maxMoves){
        int random = ThreadLocalRandom.current().nextInt(maxMoves);
        if (coordX == 0 && coordY == 0){
            int finalX;
            if (coordX + random <= SimulationSetting.getMaxX()){
                finalX = coordX + random;
                return new Object[]{Direction.RIGHT, finalX};
            } else {
                while (coordX + random != SimulationSetting.getMaxX()){
                    random--;
                }
                finalX = coordX + random;
                return new Object[]{Direction.RIGHT, finalX};

            }
        }else if (coordX == 0){
            int finalY;
            if (coordY - random >= 0){
                finalY = coordY - random;
                return new Object[]{Direction.UP, finalY};
            } else {
                while (coordY - random != 0){
                    random--;
                }
                finalY = coordY - random;
                return new Object[]{Direction.UP, finalY};
            }
        } else if (coordY == 0) {
            int finalY;
            if (coordY + random <= SimulationSetting.getMaxY()){
                finalY = coordY + random;
                return new Object[] {Direction.DOWN, finalY};
            }else {
                while (coordY + random != SimulationSetting.getMaxY()){
                    random--;
                }
                finalY = coordY - random;
                return new Object[] {Direction.DOWN, finalY};
            }
        }else {
            int finalX;
            if (coordX - random >= 0){
                finalX = coordY - random;
                return new Object[]{Direction.LEFT, finalX};
            }else {
                while (coordX - random != 0){
                    random++;
                }
                finalX = coordY - random;
                return new Object[]{Direction.LEFT, finalX};
            }
        }
    }

    public abstract void reproduce();
    public abstract void dying();


}
