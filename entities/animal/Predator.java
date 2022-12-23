package entities.animal;


import entities.location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public final Animal eat(Location location) {
        ArrayList<Animal> allAnimals = location.getAllAnimals();
        for (Animal animalToEat : allAnimals) {
            if (animalToEat instanceof Predator){
                int bound = eatProbability(this.getPredatorToEat(), animalToEat);
                Animal eated = isEated(bound, location, animalToEat);
                if (eated != null){
                    return eated;
                }
            } else if (animalToEat instanceof Herbivore){
                int bound = eatProbability(this.getHerbivoreToEat(), animalToEat);
                Animal eated = isEated(bound, location, animalToEat);
                if (eated != null){
                    return eated;
                }
            }
        }
//        int i = ThreadLocalRandom.current().nextInt(0,2);
//
//        if (i == 0) {
//            Herbivore herbivore = getHerbivore(location);
//            Integer bound = eatProbability(this.getHerbivoreToEat(), herbivore);
//            if (isEated(bound, location, herbivore)){
//                return herbivore;
//            } else {
//                System.out.println(this + " cant eat " + herbivore);
//            }
//        } else {
//            Predator predator = getPredator(location);
//            Integer bound = eatProbability(this.getPredatorToEat(), predator);
//            if(isEated(bound, location, predator)){
//                return predator;
//            } else {
//                System.out.println(this + " cant eat " + predator);
//            }
//        }
        return null;
    }

    private Herbivore getHerbivore(Location location) {
        return location.getHerbivores().get(ThreadLocalRandom.current().nextInt(location.getHerbivores().size()));
    }

    private Predator getPredator(Location location) {
        return location.getPredators().get(ThreadLocalRandom.current().nextInt(location.getPredators().size()));
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
            if (ThreadLocalRandom.current().nextInt(101) <= bound) {

                for (int i = 0; i < predators.size(); i++) {
                    if (predators.get(i).equals(animal)) {
                        return animal;
                    }
                }
            }

        } else {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            if (ThreadLocalRandom.current().nextInt(101) <= bound) {

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
