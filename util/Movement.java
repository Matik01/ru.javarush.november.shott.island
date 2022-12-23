package util;

import entities.animal.Animal;
import entities.animal.Herbivore;
import entities.animal.Predator;
import entities.location.Location;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Movement {
    ArrayList<Location> island;
    int coords;

    public Movement(ArrayList<Location> island, int coords) {
        this.island = island;
        this.coords = coords;
    }

    public Location animalMove(String animal) {
        Location location = island.get(coords);
        if (animal.equals("Predator")) {
            ArrayList<Predator> predators = location.getPredators();
            return movementChooseDirection(predators, location);
        } else if (animal.equals("Herbivore")) {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            return movementChooseDirection(herbivores, location);
        }
        return null;
    }

    private <T> Location axisMove(Location location, T animal, ArrayList<T> predators, Object[] move) {
        if (animal instanceof Predator) {
            for (int i = 0; i < island.size(); i++) {
                Location searchLocation = island.get(i);
                if (searchLocation.getCoordX() == (int) move[1] && searchLocation.getCoordY() == (int) move[2]){
                    searchLocation.getPredators().add((Predator) animal);
                    location.getPredators().remove(animal);
                    return searchLocation;
                }
            }
        }
        return null;
    }

    private <T extends Animal> Location movementChooseDirection(ArrayList<T> arrayList, Location location) {
        T animal = arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
        Object[] move = animal.move(location);
        Location newLocation = axisMove(location, animal, arrayList, move);
        System.out.println(animal + " " + move[0]);
        return newLocation;
    }
}
