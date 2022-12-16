package service;

import location.Location;
import resources.LocationSetting;
import resources.SimulationSetting;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class SimulationProcess {
    private ArrayList<Location> island;
    private SimulationSetting simulationSetting = new SimulationSetting();
    ReentrantLock locker = new ReentrantLock();
    public SimulationProcess(ArrayList<Location> island) {
        this.island = island;
    }

    public synchronized void lifeCycle(){
        int coords = getRandomCoords();
    }

    private synchronized int getRandomCoords(){
        int bound = island.size();
        return ThreadLocalRandom.current().nextInt(bound);
    }
}

