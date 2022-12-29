package entity.animal.herbivore;

import entity.animal.Herbivore;
import resource.AnimalSetting;

import java.util.Objects;

public class Deer extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;

    public Deer() {
        this.baseSetting = AnimalSetting.getDeerBaseSettings();
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
        Deer deer = (Deer) o;
        return Objects.equals(baseSetting, deer.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Deer{}";
    }
}
