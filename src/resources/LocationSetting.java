package resources;

import animals.Animal;
import animals.herbivores.*;
import animals.predators.*;
import location.Location;
import plants.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocationSetting {
    private ArrayList<Location> island = new ArrayList<>();
    private SimulationSetting simulationSetting = new SimulationSetting();

    private void createIsland() {
        for (int i = 0; i < simulationSetting.getMaxX(); i++) {
            for (int j = 0; j < simulationSetting.getMaxY(); j++) {
                island.add(new Location(i, j));
            }
        }
    }

    private void fillIsland() {
        ArrayList<Location> newIsland = new ArrayList<>(island.subList(1, island.size()));
        HashMap<Animal, Integer> wolfCount = island.get(0).getAnimalCount();
        Wolf wolf = new Wolf();
        wolfCount.put(wolf, 1);

        for (Location location : newIsland) {
            HashMap<Animal, Integer> animalCount = location.getAnimalCount();
            HashMap<Plant, Integer> plantCount = location.getPlantCount();

            int bound = 3;
            int result = ThreadLocalRandom.current().nextInt(bound);

            if (result == 0) {
                Plant plant = new Plant();
                int onSquare = ThreadLocalRandom.current().nextInt(plant.getMaxOnSquare());
                plantCount.put(plant, onSquare);
            } else if (result == 1) {
                Animal animal = predatorToCreate();
                int onSquare = ThreadLocalRandom.current().nextInt(animal.getBaseSetting().getMaxOnSquare());
                animalCount.put(animal, onSquare);
            } else {
                Animal animal = herbivoreToCreate();
                int onSquare = ThreadLocalRandom.current().nextInt(animal.getBaseSetting().getMaxOnSquare());
                animalCount.put(animal, onSquare);
            }
        }
    }

    private Animal predatorToCreate(){
        ArrayList<Animal> listOfAnimals = new ArrayList<>(List.of(new Wolf(), new Python(), new Bear(), new Eagle(), new Fox()));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }

    private Animal herbivoreToCreate(){
        ArrayList<Animal> listOfAnimals = new ArrayList<>(List.of(new Boar(), new Buffalo(), new Bunny(), new Caterpillar(), new Deer(), new Duck(), new Goat(), new Horse(), new Mouse(), new Sheep()));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }


    public void run() {
        createIsland();
        fillIsland();
        for (Location location : island) {
            System.out.println("X:" + location.getCoordX() + " Y:" + location.getCoordY() + " Animals: " + location.getAnimalCount() + "Plants: " + location.getPlantCount());
        }
        System.out.println("Created island");
    }
}
