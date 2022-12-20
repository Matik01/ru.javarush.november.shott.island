package animal;

import location.Location;
import resources.AnimalSetting;
import resources.SimulationSetting;
import util.Direction;

public abstract class Animal {
    public abstract AnimalSetting getBaseSetting();
    public final Object[] move(Location location){
        int coordX = location.getCoordX();
        int coordY = location.getCoordY();

        return chooseDirection(coordX, coordY);
    }
    private Object[] chooseDirection(int coordX, int coordY){
            if (coordX - 1 >= 0){
                return new Object[] {Direction.LEFT, coordX - 1, coordY};
            } else if (coordX + 1 <= SimulationSetting.getMaxX()) {
                return new Object[] {Direction.RIGHT, coordX + 1, coordY};
            }else if (coordY - 1 >= 0) {
                return new Object[] {Direction.UP, coordX , coordY - 1};
            }else if (coordY + 1 <= SimulationSetting.getMaxY()) {
                return new Object[] {Direction.DOWN, coordX , coordY + 1};
            }

        return null;
    }

    public abstract void reproduce();
    public abstract void dying();


}
