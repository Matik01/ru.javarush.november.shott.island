package animals.predators;

import animals.Animal;
import resources.AnimalSetting;
import animals.Predator;

public class Python extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Python(){
        this.baseSetting = AnimalSetting.getPythonBaseSettings();
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
    public void eat(Animal animal) {
        System.out.println("Eat" + animal);
    }

    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }
}
