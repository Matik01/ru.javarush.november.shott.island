package animals.herbivores;

import animals.Herbivore;
import plants.Plant;
import resources.AnimalSetting;

public class Deer extends Herbivore {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Deer() {
        this.baseSetting = AnimalSetting.getDeerBaseSettings();
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
