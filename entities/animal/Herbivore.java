package entities.animal;

import entities.animal.Animal;
import entities.animal.herbivore.Caterpillar;
import entities.location.Location;
import entities.plant.Plant;
import util.Organism;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Herbivore extends Animal {
    public final Organism eat(Location location) {
        ArrayList<Plant> plants = location.getPlants();
        if (plants.size() > 0) {
            plants.remove(plants.get(0));
        } else {
            ArrayList<Herbivore> allAnimals = location.getHerbivores();
            for (Herbivore caterpillar : allAnimals) {
                if (caterpillar instanceof Caterpillar){
                    return caterpillar;
                }
            }
        }
        return null;
    }

    public abstract Object[] getCaterpillarToEat();
}
