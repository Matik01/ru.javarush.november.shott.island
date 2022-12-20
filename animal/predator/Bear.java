package animal.predator;

import animal.Animal;
import animal.Herbivore;
import animal.herbivore.*;
import resources.AnimalSetting;
import animal.Predator;

import java.util.HashMap;

public class Bear extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;
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