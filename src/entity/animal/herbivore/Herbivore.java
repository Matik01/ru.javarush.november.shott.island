package entity.animal.herbivore;

import entity.animal.Animal;
import resource.AnimalSetting;

abstract class Herbivore extends Animal {
    public Herbivore(AnimalSetting animalSetting) {
        super(animalSetting);
    }

    @Override
    public final boolean isPredator() {
        return false;
    }

}
