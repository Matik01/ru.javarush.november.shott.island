package animal;


import location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public final Animal eat(Location location) {
        int i = ThreadLocalRandom.current().nextInt(2);

        if (i == 0) {
            Herbivore herbivore = getHerbivore(location);
            Integer bound = eatProbability(getHerbivoreToEat(), herbivore);
            if (isEated(bound, location, herbivore)){
                return herbivore;
            }
        } else {
            Predator predator = getPredator(location);
            Integer bound = eatProbability(getPredatorToEat(), predator);
            if(isEated(bound, location, predator)){
                return predator;
            }
        }

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
            if (animal.equals(element.getKey())) {
                return element.getValue();
            }
        }
        return 0;
    }

    private <T extends Animal> boolean isEated(Integer bound, Location location, T animal) {
        if (animal instanceof Predator) {
            ArrayList<Predator> predators = location.getPredators();
            if (ThreadLocalRandom.current().nextInt(101) <= bound) {

                for (int i = 0; i < predators.size(); i++) {
                    if (predators.get(i).equals(animal)) {
                        return true;
                    }
                }
            }

        } else {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            if (ThreadLocalRandom.current().nextInt(101) <= bound) {

                for (int i = 0; i < herbivores.size(); i++) {
                    if (herbivores.get(i).equals(animal)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public abstract HashMap<Class<? extends Animal>, Integer> getPredatorToEat();

    public abstract HashMap<Class<? extends Animal>, Integer> getHerbivoreToEat();
}
