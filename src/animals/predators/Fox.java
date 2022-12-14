package animals.predators;

import animals.Animal;
import resources.AnimalSetting;
import animals.Predator;

public class Fox extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Fox(){
        this.baseSetting = AnimalSetting.getFoxBaseSettings();
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

    @Override
    public void eat(Animal animal) {

    }
}
