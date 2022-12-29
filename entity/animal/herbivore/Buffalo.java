package entity.animal.herbivore;

import entity.animal.Herbivore;
import resource.AnimalSetting;

import java.util.Objects;

public class Buffalo extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;

    public Buffalo(){
        this.baseSetting = AnimalSetting.getBuffaloBaseSettings();
    }

    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buffalo buffalo = (Buffalo) o;
        return Objects.equals(baseSetting, buffalo.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public int getCaterpillarToEat() {
        return caterpillarToEat;
    }

    @Override
    public String toString() {
        return "Buffalo{}";
    }
}
