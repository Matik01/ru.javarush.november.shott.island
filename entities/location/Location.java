package entities.location;

import entities.animal.Animal;
import entities.animal.Herbivore;
import entities.animal.Predator;
import entities.plant.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private int coordX;
    private int coordY;
    private ArrayList<Predator> predators = new ArrayList<>();
    private ArrayList<Herbivore> herbivores = new ArrayList<>();
    private ArrayList<Animal> allAnimals = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock(true);


    private ArrayList<Plant> plants = new ArrayList<>();

    public Location(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordY() {
        return coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Herbivore> getHerbivores() {
        return herbivores;
    }

    public ArrayList<Predator> getPredators() {
        return predators;
    }

    public ArrayList<Animal> getAllAnimals() {
        return allAnimals;
    }

    public ArrayList<Animal> getNewAllAnimals(Animal animal) {
        ArrayList<Animal> newAnimals = new ArrayList<>();
        newAnimals.addAll(allAnimals);
        newAnimals.remove(animal);
        return newAnimals;
    }

    public void getLocationStatistics() {
        StringBuilder animals = new StringBuilder();
        ArrayList<Animal> allAnimals = this.getAllAnimals();
        ArrayList<Animal> newAnimal = new ArrayList<>();
        for (Animal allAnimal : allAnimals) {
            if (!allAnimal.equals(newAnimal)) {
                if (!newAnimal.contains(allAnimal)){
                    newAnimal.add(allAnimal);
                    int frequency = Collections.frequency(allAnimals, allAnimal);
                    animals.append(allAnimal + "=" + frequency + " ");
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        Plant newPlant = null;
        if (this.getPlants().size() > 0) {
            newPlant = this.getPlants().get(0);
        }

        System.out.printf("%d/%d: %s, %s:%d", this.getCoordX(), this.getCoordY(), animals, "Plants", Collections.frequency(this.getPlants(), newPlant));

    }

    public ReentrantLock getLock() {
        return lock;
    }
}
