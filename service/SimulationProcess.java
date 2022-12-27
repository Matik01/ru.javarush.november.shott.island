package service;

import entities.animal.Animal;
import entities.animal.Herbivore;
import entities.animal.Predator;
import entities.location.Location;
import util.Movement;

import java.util.ArrayList;

public class SimulationProcess implements Runnable {
    private ArrayList<Location> island;
    private Location location;


    public SimulationProcess(ArrayList<Location> island) {
        this.island = island;
    }

    private void tasks() {
        int predatorSize = location.getPredators().size();
        int herbivoreSize = location.getHerbivores().size();
        Movement movement = new Movement(location, island);
        if (predatorSize > 0) {
            Predator predator = location.getPredators().get(0);
            Animal eat = predator.eat(location);
            if (eat != null) {
                eat.dying(location);
            }
            predator.reproduce(location);
            movement.animalMove(predator);
        }
        if (herbivoreSize > 0) {
            Herbivore herbivore = location.getHerbivores().get(0);
            herbivore.eat(location);
            herbivore.reproduce(location);
            movement.animalMove(herbivore);
        }
    }


    @Override
    public void run() {
        tasks();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}




