package resource;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.location.Location;
import entity.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocationSetting {
    public void run() {
        createIsland();
        fillIsland();
        System.out.println("Created island");
    }

    private void createIsland() {
        for (int i = 0; i < SimulationSetting.getMaxX(); i++) {
            for (int j = 0; j < SimulationSetting.getMaxY(); j++) {
                SimulationSetting.getIsland().add(new Location(i, j));
            }
        }
    }

    private void fillIsland() {
        for (Location location : SimulationSetting.getIsland()) {
            List<Animal> allAnimals = location.getAnimals();
            List<Plant> plants = location.getPlants();

            Plant plant = new Plant();
            int onSquare = ThreadLocalRandom.current().nextInt(plant.getMaxOnSquare());
            for (int i = 0; i < onSquare; i++) {
                plants.add(plant);
            }

            Animal animal = animalObjectToCreate();
            onSquare = ThreadLocalRandom.current().nextInt((int) animal.getMaxOnSquare());
            for (int i = 0; i < onSquare; i++) {
                allAnimals.add(animal);
            }
        }
    }

    private Animal animalObjectToCreate() {
        ArrayList<Animal> listOfAnimals = new ArrayList<>(List.of(
                new Wolf(), new Python(), new Bear(), new Eagle(), new Fox(),
                new Boar(), new Buffalo(), new Bunny(), new Caterpillar(),
                new Deer(), new Duck(), new Goat(), new Horse(), new Mouse(), new Sheep()
        ));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }
}
