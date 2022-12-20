package animal.predator;

import animal.Animal;
import animal.herbivore.*;
import resources.AnimalSetting;
import animal.Predator;

import java.util.HashMap;

public class Wolf extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;
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
    public void reproduce() {

    }

    @Override
    public void dying() {

    }

    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

}
