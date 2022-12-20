package resources;

import animal.Animal;
import animal.Herbivore;
import animal.Predator;
import animal.herbivore.*;
import animal.predator.*;
import location.Location;
import plant.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocationSetting extends SimulationSetting{
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
        ArrayList<Location> viewIsland = new ArrayList<>(island.subList(0, island.size()));

        for (Location location : viewIsland) {
            ArrayList<Predator> predators = location.getPredators();
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            ArrayList<Plant> plants = location.getPlants();

            int bound = 3;
            int result = ThreadLocalRandom.current().nextInt(bound);

            if (result == 0) {
                Plant plant = new Plant();
                int onSquare = ThreadLocalRandom.current().nextInt(plant.getMaxOnSquare());
                for (int i = 0; i < onSquare; i++) {
                    plants.add(plant);
                }
            } else if (result == 1) {
                Predator animal = predatorToCreate();
                int onSquare = ThreadLocalRandom.current().nextInt(animal.getBaseSetting().getMaxOnSquare());
                for (int i = 0; i < onSquare; i++) {
                    predators.add(animal);
                }
            } else {
                Herbivore animal = herbivoreToCreate();
                int onSquare = ThreadLocalRandom.current().nextInt(animal.getBaseSetting().getMaxOnSquare());
                for (int i = 0; i < onSquare; i++) {
                    herbivores.add(animal);
                }

            }
        }
    }

    private Predator predatorToCreate(){
        ArrayList<Predator> listOfAnimals = new ArrayList<>(List.of(new Wolf(), new Python(), new Bear(), new Eagle(), new Fox()));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }

    private Herbivore herbivoreToCreate(){
        ArrayList<Herbivore> listOfAnimals = new ArrayList<>(List.of(new Boar(), new Buffalo(), new Bunny(), new Caterpillar(),
                                                                    new Deer(), new Duck(), new Goat(), new Horse(), new Mouse(), new Sheep()));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }


    public void run() {
        createIsland();
        fillIsland();

        System.out.println("Created island");
    }

    public ArrayList<Location> getIsland() {
        return island;
    }
}
