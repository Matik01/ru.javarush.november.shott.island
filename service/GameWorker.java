package service;

import entities.location.Location;
import resources.LocationSetting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    LocationSetting locationSetting;
    SimulationProcess simulationProcess;

    public GameWorker(LocationSetting locationSetting) {
        this.locationSetting = locationSetting;
    }

    @Override
    public void run() {
        locationSetting.simulationStatistics();

        simulationProcess = new SimulationProcess(locationSetting.getIsland());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);
        executorService.scheduleWithFixedDelay(this::locationRun, 20, 20, TimeUnit.MILLISECONDS);
    }


    public void locationRun() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
        for (Location location : locationSetting.getIsland()) {
            simulationProcess.setLocation(location);
            fixedThreadPool.submit(simulationProcess);

        }
        fixedThreadPool.shutdown();
        locationSetting.simulationStatistics();
    }
}
