package util;

import animal.Animal;
import animal.Herbivore;
import animal.Predator;
import location.Location;

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
            return animalChooseDirection(predators, location);
        } else if (animal.equals("Herbivore")) {
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            return animalChooseDirection(herbivores, location);
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

    private <T extends Animal> Location animalChooseDirection(ArrayList<T> arrayList, Location location) {
        T animal = arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
        Object[] move = animal.move(location);
        if (move[0].equals(Direction.UP)) {
            Location newLocation = axisMove(location, animal, arrayList, move);
            System.out.println(animal + "moved UP");
            return newLocation;
        } else if (move[0].equals(Direction.RIGHT)) {
            Location newLocation = axisMove(location, animal, arrayList, move);
            System.out.println(animal + "moved RIGHT");
            return newLocation;
        } else if (move[0].equals(Direction.DOWN)) {
            Location newLocation = axisMove(location, animal, arrayList, move);
            System.out.println(animal + "moved DOWN");
            return newLocation;
        } else if (move[0].equals(Direction.LEFT)) {
            Location newLocation = axisMove(location, animal, arrayList, move);
            System.out.println(animal + "moved LEFT");
            return newLocation;
        }
        return null;
    }
}
