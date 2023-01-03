package resource;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.location.Location;
import entity.plant.Plant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocationSetting extends SimulationSetting {
    private ArrayList<Location> island = new ArrayList<>();

    private void createIsland() {
        for (int i = 0; i < SimulationSetting.getMaxX(); i++) {
            for (int j = 0; j < SimulationSetting.getMaxY(); j++) {
                island.add(new Location(i, j));
            }
        }
    }

    private void fillIsland() {
        ArrayList<Location> viewIsland = new ArrayList<>(island.subList(0, island.size()));

        for (Location location : viewIsland) {
            ArrayList<Predator> predators = location.getPredators();
            ArrayList<Herbivore> herbivores = location.getHerbivores();
            ArrayList<Animal> allAnimals = location.getAllAnimals();
            ArrayList<Plant> plants = location.getPlants();

            Plant plant = new Plant();
            int onSquare = ThreadLocalRandom.current().nextInt(plant.getMaxOnSquare());
            for (int i = 0; i < onSquare; i++) {
                plants.add(plant);
            }

            Predator predator = predatorToCreate();
            onSquare = ThreadLocalRandom.current().nextInt(predator.getBaseSetting().getMaxOnSquare());
            for (int i = 0; i < onSquare; i++) {
                predators.add(predator);
            }

            Herbivore herbivore = herbivoreToCreate();
            onSquare = ThreadLocalRandom.current().nextInt(herbivore.getBaseSetting().getMaxOnSquare());
            for (int i = 0; i < onSquare; i++) {
                herbivores.add(herbivore);
            }
            allAnimals.addAll(predators);
            allAnimals.addAll(herbivores);
        }
    }


    private Predator predatorToCreate() {
        ArrayList<Predator> listOfAnimals = new ArrayList<>(List.of(new Wolf(), new Python(), new Bear(), new Eagle(), new Fox()));
        int bound = listOfAnimals.size();
        return listOfAnimals.get(ThreadLocalRandom.current().nextInt(bound));
    }

    private Herbivore herbivoreToCreate() {
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

    public void simulationStatistics() {
        for (Location location : island) {
            location.getLocationStatistics();
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        }
    }

}
