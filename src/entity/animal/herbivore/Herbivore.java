package entity.animal.herbivore;

import entity.animal.Animal;
import entity.location.Location;
import entity.plant.Plant;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {
    public final void eat(Location location) {
        ArrayList<Plant> plants = location.getPlants();
        if (plants.size() > 0) {
            plants.remove(plants.get(0));
        } else {
            ArrayList<Herbivore> allAnimals = location.getHerbivores();
            for (Herbivore caterpillar : allAnimals) {
                if (caterpillar instanceof Caterpillar && isEated()) {
                    location.getHerbivores().remove(caterpillar);
                    location.getAllAnimals().remove(caterpillar);
                } else {
                    this.starve();
                }
            }
        }
    }

    private boolean isEated() {
        int caterpillarToEat = this.getCaterpillarToEat();
        int random = ThreadLocalRandom.current().nextInt(101);
        if (random <= caterpillarToEat) {
            return true;
        } else {
            return false;
        }
    }

    public abstract int getCaterpillarToEat();
}
