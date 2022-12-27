package entities.animal.herbivore;

import entities.animal.Herbivore;
import resources.AnimalSetting;

import java.util.Objects;

public class Goat extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

    public Goat(){
        this.baseSetting = AnimalSetting.getGoatBaseSettings();
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
        Goat goat = (Goat) o;
        return Objects.equals(baseSetting, goat.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Goat{}";
    }
}
