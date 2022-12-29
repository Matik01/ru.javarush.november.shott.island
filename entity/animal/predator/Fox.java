package entity.animal.predator;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import resource.AnimalSetting;
import entity.animal.Predator;

import java.util.HashMap;
import java.util.Objects;

public class Fox extends Predator {
    private AnimalSetting baseSetting;
    private HashMap<Class<? extends Animal>, Integer> herbivoreToEat = new HashMap<>(){
        {
            put(Horse.class, 0);
            put(Deer.class, 0);
            put(Bunny.class, 70);
            put(Mouse.class, 90);
            put(Goat.class, 0);
            put(Sheep.class, 0);
            put(Boar.class, 0);
            put(Buffalo.class, 0);
            put(Duck.class, 80);
            put(Caterpillar.class, 40);
        }
    };
    private HashMap<Class<? extends Animal>, Integer> predatorToEat = new HashMap<>(){
        {
            put(Wolf.class, 0);
            put(Python.class, 0);
            put(Bear.class, 0);
            put(Eagle.class, 0);
        }
    };

    public Fox() {
        this.baseSetting = AnimalSetting.getFoxBaseSettings();
    }



    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public HashMap<Class<? extends Animal>, Integer> getPredatorToEat() {
        return predatorToEat;
    }

    @Override
    public HashMap<Class<? extends Animal>, Integer> getHerbivoreToEat() {
        return herbivoreToEat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fox fox = (Fox) o;
        return Objects.equals(baseSetting, fox.baseSetting) && Objects.equals(herbivoreToEat, fox.herbivoreToEat) && Objects.equals(predatorToEat, fox.predatorToEat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting, herbivoreToEat, predatorToEat);
    }

    @Override
    public String toString() {
        return "Fox{}";
    }
}
