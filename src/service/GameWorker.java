package service;

import resources.LocationSetting;
import resources.SimulationSetting;

public class GameWorker {
    public static void main(String[] args) {
        LocationSetting locationSetting = new LocationSetting();
        SimulationSetting simulationSetting = new SimulationSetting();
        simulationSetting.setMaxX(Integer.parseInt(args[0]));
        simulationSetting.setMaxY(Integer.parseInt(args[1]));
        locationSetting.run();
    }
}
