package service;

import entities.location.Location;
import util.Movement;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationProcess implements Runnable {
    private ArrayList<Location> island;

    public SimulationProcess(ArrayList<Location> island) {
        this.island = island;
    }

    private void lifeCycle() {
        for (Location location : island) {
            location.getLocationStatistics();
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        }
//        Location location = predatorMove(searchPredatorLocation());
//        for (Predator predator : location.getPredators()) {
//            Animal eat = predator.eat(location);
//            if (eat != null) {
//                System.out.println(predator + " eated " + predator.eat(location));
//            }
//            break;
//        }
//        location = herbivoreMove(searchHerbivoreLocation());
//        herbivoreMove(searchHerbivoreLocation());
    }

    private synchronized int getRandomCoords() {
        int bound = island.size();
        return ThreadLocalRandom.current().nextInt(bound);
    }

    private synchronized Location predatorMove(int coords) {
        Movement movement = new Movement(island, coords);
        return movement.animalMove("Predator");
    }

    private synchronized Location herbivoreMove(int coords) {
        Movement movement = new Movement(island, coords);
        return movement.animalMove("Herbivore");
    }

    private int searchPredatorLocation() {
        int coords = getRandomCoords();
        if (island.get(coords).getPredators().size() > 0) {
            return coords;
        } else {
            getRandomCoords();
        }
        return coords;
    }

    private int searchHerbivoreLocation() {
        int coords = getRandomCoords();
        if (island.get(coords).getHerbivores().size() > 0) {
            return coords;
        } else {
            searchHerbivoreLocation();
        }
        return coords;
    }

    private Location searchLocation() {
        int coords = getRandomCoords();
        Location location = island.get(coords);
        if (location.getHerbivores().size() > 0 || location.getPredators().size() > 0) {
            return location;
        } else {
            searchLocation();
        }
        return location;
    }

    @Override
    public void run() {
        lifeCycle();
    }
}



