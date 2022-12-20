package animal.predator;

import animal.Animal;
import animal.Herbivore;
import animal.herbivore.*;
import resources.AnimalSetting;
import animal.Predator;

import java.util.HashMap;

public class Eagle extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;
    private HashMap<Class<? extends Animal>, Integer> herbivoreToEat = new HashMap<>(){
        {
            put(Horse.class, 0);
            put(Deer.class, 0);
            put(Bunny.class, 90);
            put(Mouse.class, 90);
            put(Goat.class, 0);
            put(Sheep.class, 0);
            put(Boar.class, 0);
            put(Buffalo.class, 0);
            put(Duck.class, 80);
            put(Caterpillar.class, 0);
        }
    };
    private HashMap<Class<? extends Animal>, Integer> predatorToEat = new HashMap<>(){
        {
            put(Wolf.class, 0);
            put(Python.class, 0);
            put(Bear.class, 0);
            put(Fox.class, 10);
        }
    };

    public Eagle(){
        this.baseSetting = AnimalSetting.getEagleBaseSettings();
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

    @Override
    public HashMap<Class<? extends Animal>, Integer> getPredatorToEat() {
        return predatorToEat;
    }

    @Override
    public HashMap<Class<? extends Animal>, Integer> getHerbivoreToEat() {
        return herbivoreToEat;
    }
}
