package entities.animal.herbivore;

import entities.animal.Herbivore;
import entities.location.Location;
import resources.AnimalSetting;

import java.util.Objects;

public class Buffalo extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

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
