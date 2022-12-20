package service;

import location.Location;
import resources.LocationSetting;
import resources.SimulationSetting;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameWorker {
    public static void main(String[] args) {
        LocationSetting locationSetting = new LocationSetting();
        locationSetting.setMaxX(Integer.parseInt(args[0]));
        locationSetting.setMaxY(Integer.parseInt(args[1]));
        locationSetting.run();
        SimulationProcess simulationProcess = new SimulationProcess(locationSetting.getIsland());
        simulationProcess.run();

    }
}
