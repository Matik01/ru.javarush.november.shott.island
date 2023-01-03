package service;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.location.Location;
import util.Movement;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
            Predator predator = location.getPredators().get(ThreadLocalRandom.current().nextInt(location.getPredators().size()));
            Animal eat = predator.eat(location);
            if (eat != null) {
                eat.dying(location);
            }
            if (predator.getBaseSetting().getMaxSatiety() <= 0){
                predator.dying(location);
            }
            predator.reproduce(location);
            movement.animalMove(predator);
        }
        if (herbivoreSize > 0) {
            Herbivore herbivore = location.getHerbivores().get(ThreadLocalRandom.current().nextInt(location.getHerbivores().size()));
            herbivore.eat(location);
            if (herbivore.getBaseSetting().getMaxSatiety() <= 0){
                herbivore.dying(location);
            }
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




