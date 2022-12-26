package entities.animal.herbivore;

import entities.animal.Herbivore;
import entities.location.Location;
import resources.AnimalSetting;

import java.util.Objects;

public class Mouse extends Herbivore {
    private AnimalSetting baseSetting;
    private Object[] caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

    public Mouse(){
        this.baseSetting = AnimalSetting.getMouseBaseSettings();
    }


    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public Object[] getCaterpillarToEat() {
        return caterpillarToEat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mouse mouse = (Mouse) o;
        return Objects.equals(baseSetting, mouse.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Mouse{}";
    }
}
