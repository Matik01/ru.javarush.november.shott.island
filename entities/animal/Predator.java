package entities.animal;


import entities.location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public final Animal eat(Location location) {
        location.getLock().lock();
        try {
            ArrayList<Animal> allAnimals = location.getAllAnimals();
            Animal eated = null;
            for (Animal animalToEat : allAnimals) {
                if (animalToEat instanceof Predator) {
                    HashMap<Class<? extends Animal>, Integer> predatorToEat = this.getPredatorToEat();
                    int bound = eatProbability(predatorToEat, animalToEat);
                    eated = isEated(bound, location, animalToEat);
                    if (eated != null) {
                        return eated;
                    }
                } else if (animalToEat instanceof Herbivore) {
                    int bound = eatProbability(this.getHerbivoreToEat(), animalToEat);
                    eated = isEated(bound, location, animalToEat);
                    if (eated != null) {
                        return eated;
                    }
                }
            }
            return eated;
        } finally {
            location.getLock().unlock();
        }
    }

    private <T> Integer eatProbability(HashMap<Class<? extends Animal>, Integer> hashMap, T animal) {
        for (Map.Entry<Class<? extends Animal>, Integer> element : hashMap.entrySet()) {
            if (animal.getClass().equals(element.getKey())) {
                return element.getValue();
            }
        }
        return 0;
    }

    private <T extends Animal> T isEated(Integer bound, Location location, T animal) {
        if (animal instanceof Predator) {
            ArrayList<Predator> predators = location.getPredators();
            if (ThreadLocalRandom.current().nextInt(101) < bound) {

                for (int i = 0; i < predators.size(); i++) {
                    if (predators.get(i).equals(animal)) {
                        return animal;
                    }
                }
            }

        } else {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            if (ThreadLocalRandom.current().nextInt(101) < bound) {

                for (int i = 0; i < herbivores.size(); i++) {
                    if (herbivores.get(i).equals(animal)) {
                        return animal;
                    }
                }
            }

        }
        return null;
    }

    public abstract HashMap<Class<? extends Animal>, Integer> getPredatorToEat();

    public abstract HashMap<Class<? extends Animal>, Integer> getHerbivoreToEat();
}
