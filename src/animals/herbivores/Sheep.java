package animals.herbivores;

import resources.AnimalSetting;
import animals.Herbivore;
import plants.Plant;

public class Sheep extends Herbivore {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Sheep(){
        this.baseSetting = AnimalSetting.getSheepBaseSettings();
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
    public void eat(Plant plant) {

    }
}
