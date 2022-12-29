package entities.animal.predator;

import entities.animal.Animal;
import entities.animal.herbivore.*;
import resources.AnimalSetting;
import entities.animal.Predator;

import java.util.HashMap;
import java.util.Objects;

public class Wolf extends Predator {
    private AnimalSetting baseSetting;
    private final HashMap<Class<? extends Animal>, Integer> herbivoreToEat = new HashMap<>() {
        {
            put(Horse.class, 10);
            put(Deer.class, 15);
            put(Bunny.class, 60);
            put(Mouse.class, 80);
            put(Goat.class, 60);
            put(Sheep.class, 70);
            put(Boar.class, 15);
            put(Buffalo.class, 10);
            put(Duck.class, 40);
            put(Caterpillar.class, 0);
        }
    };

    private final HashMap<Class<? extends Animal>, Integer> predatorToEat = new HashMap<>() {
        {
            put(Python.class, 0);
            put(Fox.class, 0);
            put(Bear.class, 0);
            put(Eagle.class, 0);
        }
    };

    public Wolf() {
        this.baseSetting = AnimalSetting.getWolfBaseSettings();
    }

    @Override
    public HashMap<Class<? extends Animal>, Integer> getHerbivoreToEat() {
        return herbivoreToEat;
    }

    @Override
    public HashMap<Class<? extends Animal>, Integer> getPredatorToEat() {
        return predatorToEat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return Objects.equals(baseSetting, wolf.baseSetting) && Objects.equals(herbivoreToEat, wolf.herbivoreToEat) && Objects.equals(predatorToEat, wolf.predatorToEat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting, herbivoreToEat, predatorToEat);
    }

    @Override
    public String toString() {
        return "Wolf{}";
    }

    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

}
