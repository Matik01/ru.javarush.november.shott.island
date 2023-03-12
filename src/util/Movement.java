package util;

import entity.animal.Animal;
import entity.location.Location;
import resource.SimulationSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Movement {
    List<Location> island;
    Location location;
    Animal animalToMove;

    public Movement(Location location, Animal animal) {
        this.location = location;
        this.island = SimulationSetting.getIsland();
        this.animalToMove = animal;
    }

    public List<Location> findPossibleLocations() {
        List<Location> locationList = new ArrayList<>();
        int coordX = location.getCoordX();
        int coordY = location.getCoordY();
        float maxMoveSize = animalToMove.getMaxMoveSize();

        if (coordX - maxMoveSize >= 0) {
            Location locationToMove = island.get(coordX - randomMoveSize(maxMoveSize));
            locationList.add(locationToMove);
        }
        if (coordX + maxMoveSize <= SimulationSetting.getMaxX()) {
            Location locationToMove = island.get(coordX + randomMoveSize(maxMoveSize));
            locationList.add(locationToMove);
        }
        if (coordY - maxMoveSize >= 0) {
            Location locationToMove = island.get(coordY - randomMoveSize(maxMoveSize));
            locationList.add(locationToMove);
        }
        if (coordY + maxMoveSize <= SimulationSetting.getMaxY()) {
            Location locationToMove = island.get(coordY + randomMoveSize(maxMoveSize));
            locationList.add(locationToMove);
        }
        return locationList;
    }

    private int randomMoveSize(float maxMoveSize) {
        if (maxMoveSize > 0) {
            return (int) ThreadLocalRandom.current().nextFloat(maxMoveSize);
        } else {
            return 0;
        }
        //Exception in thread "main" java.lang.IllegalArgumentException: bound must be finite and positive
    }

}


