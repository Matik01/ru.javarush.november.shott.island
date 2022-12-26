package entities.animal.predator;

import entities.animal.Animal;
import entities.animal.herbivore.*;
import resources.AnimalSetting;
import entities.animal.Predator;

import java.util.HashMap;
import java.util.Objects;

public class Python extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;
    private final HashMap<Class<? extends Animal>, Integer> herbivoreToEat = new HashMap<>(){
        {
            put(Horse.class, 0);
            put(Deer.class, 0);
            put(Bunny.class, 20);
            put(Mouse.class, 40);
            put(Goat.class, 0);
            put(Sheep.class, 0);
            put(Boar.class, 0);
            put(Buffalo.class, 0);
            put(Duck.class, 10);
            put(Caterpillar.class, 0);
        }
    };
    private HashMap<Class<? extends Animal>, Integer> predatorToEat = new HashMap<>(){
        {
            put(Wolf.class, 0);
            put(Fox.class, 15);
            put(Bear.class, 0);
            put(Eagle.class, 0);
        }
    };

    public Python(){
        this.baseSetting = AnimalSetting.getPythonBaseSettings();
    }




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
        Python python = (Python) o;
        return Objects.equals(baseSetting, python.baseSetting) && Objects.equals(herbivoreToEat, python.herbivoreToEat) && Objects.equals(predatorToEat, python.predatorToEat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting, herbivoreToEat, predatorToEat);
    }

    @Override
    public String toString() {
        return "Python{}";
    }
}
