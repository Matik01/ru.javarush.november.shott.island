package entity.animal.herbivore;

import resource.AnimalSetting;
import entity.animal.Herbivore;

import java.util.Objects;

public class Sheep extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;

    public Sheep(){
        this.baseSetting = AnimalSetting.getSheepBaseSettings();
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
        Sheep sheep = (Sheep) o;
        return Objects.equals(baseSetting, sheep.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Sheep{}";
    }
}
