package animal.herbivore;

import location.Location;
import resources.AnimalSetting;
import animal.Herbivore;

public class Sheep extends Herbivore {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Sheep(){
        this.baseSetting = AnimalSetting.getSheepBaseSettings();
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
    public void eat(Location location) {

    }
}
