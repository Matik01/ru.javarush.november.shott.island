package entity.animal.predator;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import resource.AnimalSetting;
import entity.animal.predator.*;

import java.util.HashMap;
import java.util.Objects;

public class Bear extends Predator {
    private AnimalSetting baseSetting;
    private HashMap<Class<? extends Animal>, Integer> herbivoreToEat = new HashMap<>(){
        {
            put(Horse.class, 40);
            put(Deer.class, 80);
            put(Bunny.class, 80);
            put(Mouse.class, 90);
            put(Goat.class, 70);
            put(Sheep.class, 70);
            put(Boar.class, 50);
            put(Buffalo.class, 20);
            put(Duck.class, 10);
            put(Caterpillar.class, 0);
        }
    };
    private HashMap<Class<? extends Animal>, Integer> predatorToEat = new HashMap<>(){
        {
            put(Wolf.class, 0);
            put(Python.class, 80);
            put(Eagle.class, 0);
            put(Fox.class, 0);
        }
    };

    public Bear(){
        this.baseSetting = AnimalSetting.getBearBaseSettings();
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
        Bear bear = (Bear) o;
        return Objects.equals(baseSetting, bear.baseSetting) && Objects.equals(herbivoreToEat, bear.herbivoreToEat) && Objects.equals(predatorToEat, bear.predatorToEat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting, herbivoreToEat, predatorToEat);
    }

    @Override
    public String toString() {
        return "Bear{}";
    }
}
