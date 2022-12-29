package entity.animal.herbivore;

import entity.animal.Herbivore;
import resource.AnimalSetting;

import java.util.Objects;

public class Duck extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat = 90;

    public Duck(){
        this.baseSetting = AnimalSetting.getDuckBaseSettings();
    }


    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public int getCaterpillarToEat() {
        return caterpillarToEat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return Objects.equals(baseSetting, duck.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Duck{}";
    }
}
