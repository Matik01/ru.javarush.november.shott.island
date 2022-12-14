package animals.predators;

import animals.Animal;
import resources.AnimalSetting;
import animals.Predator;

public class Wolf extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Wolf() {
        this.baseSetting = AnimalSetting.getWolfBaseSettings();
    }

    @Override
    public void eat(Animal animal) {
        System.out.println("Eat" + animal);
    }

    @Override
    public void move() {
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
