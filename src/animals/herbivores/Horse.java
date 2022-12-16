package animals.herbivores;

import animals.Herbivore;
import plants.Plant;
import resources.AnimalSetting;

public class Horse extends Herbivore {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;
    public Horse(){
        this.baseSetting = AnimalSetting.getHorseBaseSettings();
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
