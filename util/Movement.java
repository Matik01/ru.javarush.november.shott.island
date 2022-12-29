package util;

import entities.animal.Animal;
import entities.animal.Herbivore;
import entities.animal.Predator;
import entities.location.Location;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Movement {
    ArrayList<Location> island;
    Location location;

    public Movement(Location location, ArrayList<Location> island) {
        this.location = location;
        this.island = island;
    }


    public <T extends Animal> Location animalMove(T animal) {
        if (animal instanceof Predator && animal.getBaseSetting().getMaxMoves() > 0) {
            ArrayList<Predator> predators = location.getPredators();
            return movementChooseDirection(predators, location);
        } else if (animal instanceof Herbivore && animal.getBaseSetting().getMaxMoves() > 0) {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            return movementChooseDirection(herbivores, location);
        }
        return null;

    }

    private <T extends Animal> Location movementChooseDirection(ArrayList<T> arrayList, Location location) {
        T animal = arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
        Object[] move = animal.move(location);
        Location newLocation = axisMove(location, animal, arrayList, move);
        return newLocation;
    }

    private <T> Location axisMove(Location location, T animal, ArrayList<T> predators, Object[] move) {
        if (animal instanceof Predator) {
            for (int i = 0; i < island.size(); i++) {
                Location searchLocation = island.get(i);
                if (searchLocation.getCoordX() == (int) move[1] && searchLocation.getCoordY() == (int) move[2]) {
                    searchLocation.getLock().lock();
                    try {
                        searchLocation.getPredators().add((Predator) animal);
                        searchLocation.getAllAnimals().add((Animal) animal);
                        location.getPredators().remove(animal);
                        location.getAllAnimals().remove(animal);
                        return searchLocation;
                    } finally {
                        searchLocation.getLock().unlock();
                    }
                }
            }
        } else if (animal instanceof Herbivore) {
            for (int i = 0; i < island.size(); i++) {
                Location searchLocation = island.get(i);
                if (searchLocation.getCoordX() == (int) move[1] && searchLocation.getCoordY() == (int) move[2]) {
                    searchLocation.getHerbivores().add((Herbivore) animal);
                    searchLocation.getAllAnimals().add((Animal) animal);
                    location.getHerbivores().remove(animal);
                    return searchLocation;
                }
            }
        }
        return null;
    }
}
