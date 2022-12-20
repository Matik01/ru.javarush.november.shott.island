package animal.herbivore;

import animal.Herbivore;
import location.Location;
import resources.AnimalSetting;

public class Mouse extends Herbivore {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Mouse(){
        this.baseSetting = AnimalSetting.getMouseBaseSettings();
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