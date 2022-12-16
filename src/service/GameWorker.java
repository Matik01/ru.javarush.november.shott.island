package service;

import animals.predators.Wolf;
import location.Location;
import resources.LocationSetting;
import resources.SimulationSetting;

public class GameWorker {
    public static void main(String[] args) {
        LocationSetting locationSetting = new LocationSetting();
        SimulationSetting simulationSetting = new SimulationSetting();
        simulationSetting.setMaxX(Integer.parseInt(args[0]));
        simulationSetting.setMaxY(Integer.parseInt(args[1]));
        locationSetting.run();
        for (Location location : locationSetting.getIsland()) {
            System.out.println("X:" + location.getCoordX() + " Y:" + location.getCoordY() + " Animals: " + location.getAnimalCount() + "Plants: " + location.getPlantCount());
        }
        SimulationProcess simulationProcess = new SimulationProcess(locationSetting.getIsland());

    }
}
