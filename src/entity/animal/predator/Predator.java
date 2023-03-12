package entity.animal.predator;


import entity.animal.Animal;
import entity.location.Location;
import resource.AnimalSetting;
import java.util.List;
abstract class Predator extends Animal {
    protected Predator(AnimalSetting animalSetting) {
        super(animalSetting);
    }

    @Override
    public final boolean isPredator() {
        return true;
    }

    public final Animal eat(Location location) {
        List<Animal> allAnimals = location.getAnimals();
        Animal eated = null;
        for (Animal animalToEat : allAnimals) {

        }
        return eated;

    }
}
