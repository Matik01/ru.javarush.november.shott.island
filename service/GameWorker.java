package service;

import entities.location.Location;
import resources.LocationSetting;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    LocationSetting locationSetting;
    SimulationProcess simulationProcess;
    ArrayList<Location> island;

    public GameWorker(LocationSetting locationSetting) {
        this.locationSetting = locationSetting;
        this.island = locationSetting.getIsland();
    }

    @Override
    public void run() {
        locationSetting.simulationStatistics();

        simulationProcess = new SimulationProcess(locationSetting.getIsland());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);
        executorService.scheduleWithFixedDelay(this::locationRun, 20, 5000, TimeUnit.MILLISECONDS);
    }


    private synchronized void locationRun() {
        for (Location location : island) {
            simulationProcess.setLocation(location);
            simulationProcess.run();


        }
        locationSetting.simulationStatistics();

    }
}
