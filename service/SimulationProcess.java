package service;

import animal.Animal;
import animal.Direction;
import animal.Predator;
import animal.predator.Wolf;
import location.Location;
import resources.LocationSetting;
import resources.SimulationSetting;
import util.Movement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class SimulationProcess implements Runnable{
    private ArrayList<Location> island;

    public SimulationProcess(ArrayList<Location> island) {
        this.island = island;
    }

    private synchronized void lifeCycle() {
        int coords = getRandomCoords();
        Movement movement = new Movement(island, coords);
        Location location = movement.animalMove();
        for (Predator predator : location.getPredators()) {
            Animal eat = predator.eat(location);
            if (eat != null){
                System.out.println(predator + " eated " + predator.eat(location));
            } else {
                System.out.println(predator + " can not eat " + predator.eat(location));
            }
        }
    }

    private synchronized int getRandomCoords() {
        int bound = island.size();
        return ThreadLocalRandom.current().nextInt(bound);
    }


    @Override
    public void run() {
        lifeCycle();
    }
}



