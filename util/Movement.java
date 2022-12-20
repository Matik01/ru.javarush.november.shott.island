package util;

import animal.Direction;
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

    public Location animalMove() {
        Location location = island.get(coords);
        ArrayList<Predator> predators = location.getPredators();
        Predator predator = predators.get(ThreadLocalRandom.current().nextInt(predators.size()));
        int maxMoves = predator.getBaseSetting().getMaxMoves();
        Object[] move = predator.move(location, maxMoves);
        if (move[0].equals(Direction.UP)) {
            Location newLocation = yAxisMove(location, predator, predators, move);
            System.out.println(predator + "moved UP");
            return newLocation;
        } else if (move[0].equals(Direction.RIGHT)) {
            Location newLocation = xAxisMove(location, predator, predators, move);
            System.out.println(predator + "moved RIGHT");
            return newLocation;
        } else if (move[0].equals(Direction.DOWN)) {
            Location newLocation = yAxisMove(location, predator, predators, move);
            System.out.println(predator + "moved DOWN");
            return newLocation;
        } else if (move[0].equals(Direction.LEFT)) {
            Location newLocation = xAxisMove(location, predator, predators, move);
            System.out.println(predator + "moved LEFT");
            return newLocation;
        }
        return null;
    }

    private Location xAxisMove(Location location, Predator predator, ArrayList<Predator> predators, Object[] move) {
        for (int i = 0; i < island.size(); i++) {
            Location searchLocation = island.get(i);
            if (searchLocation.getCoordY() == location.getCoordY() && searchLocation.getCoordX() == (int) move[1]) {
                searchLocation.getPredators().add(predator);
                predators.remove(predator);
                return searchLocation;
            }
        }
        return null;
    }

    private Location yAxisMove(Location location, Predator predator, ArrayList<Predator> predators, Object[] move) {
        for (int i = 0; i < island.size(); i++) {
            Location searchLocation = island.get(i);
            if (searchLocation.getCoordX() == location.getCoordX() && searchLocation.getCoordY() == (int) move[1]) {
                searchLocation.getPredators().add(predator);
                predators.remove(predator);
                return searchLocation;
            }
        }
        return null;
    }
}
