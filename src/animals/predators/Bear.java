package animals.predators;

import animals.Animal;
import resources.AnimalSetting;
import animals.Predator;

public class Bear extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Bear(){
        this.baseSetting = AnimalSetting.getBearBaseSettings();
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
