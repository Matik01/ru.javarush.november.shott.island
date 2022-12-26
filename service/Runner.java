package service;

import resources.LocationSetting;

public class Runner {
    public static void main(String[] args) {
        LocationSetting locationSetting = new LocationSetting();
        locationSetting.setMaxX(Integer.parseInt(args[0]));
        locationSetting.setMaxY(Integer.parseInt(args[1]));
        locationSetting.run();
        GameWorker gameWorker = new GameWorker(locationSetting);
        gameWorker.start();
    }
}