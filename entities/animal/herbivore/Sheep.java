package entities.animal.herbivore;

import entities.location.Location;
import resources.AnimalSetting;
import entities.animal.Herbivore;

public class Sheep extends Herbivore {
    private AnimalSetting baseSetting;
    private Object[] caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

    public Sheep(){
        this.baseSetting = AnimalSetting.getSheepBaseSettings();
    }


    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public Object[] getCaterpillarToEat() {
        return caterpillarToEat;
    }
}
