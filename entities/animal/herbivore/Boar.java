package entities.animal.herbivore;

import entities.animal.Herbivore;
import resources.AnimalSetting;

import java.util.Objects;

public class Boar extends Herbivore {
    private AnimalSetting baseSetting;
    private Object[] caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

    public Boar(){
        this.baseSetting = AnimalSetting.getBoarBaseSettings();
    }


    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boar boar = (Boar) o;
        return Objects.equals(baseSetting, boar.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public Object[] getCaterpillarToEat() {
        return caterpillarToEat;
    }

    @Override
    public String toString() {
        return "Boar{}";
    }
}
