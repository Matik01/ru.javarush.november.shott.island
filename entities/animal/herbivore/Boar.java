package entities.animal.herbivore;

import entities.animal.Herbivore;
import entities.location.Location;
import resources.AnimalSetting;

public class Boar extends Herbivore {
    private AnimalSetting baseSetting;
    private Object[] caterpillarToEat;
    private int satiety = 0;
    private int moves = 0;

    public Boar(){
        this.baseSetting = AnimalSetting.getBoarBaseSettings();
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
