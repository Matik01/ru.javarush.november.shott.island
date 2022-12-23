package entities.location;

import entities.animal.Animal;
import entities.animal.Herbivore;
import entities.animal.Predator;
import entities.plant.Plant;

import java.util.ArrayList;

public class Location {
    private int coordX;
    private int coordY;
    private ArrayList<Predator> predators = new ArrayList<>();
    private ArrayList<Herbivore> herbivores = new ArrayList<>();
    private ArrayList<Animal> allAnimals = new ArrayList<>();



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

    public ArrayList<Animal> getNewAllAnimals(Animal animal){
        ArrayList<Animal> newAnimals = new ArrayList<>();
        newAnimals.addAll(allAnimals);
        newAnimals.remove(animal);
        return newAnimals;
    }

    public void getLocationStatistics(){
        StringBuilder animals = new StringBuilder();
        for (Animal allAnimal : this.getAllAnimals()) {
            animals.append(allAnimal + "= ");
        }
        System.out.printf("%d/%d: %s", this.getCoordX(), this.getCoordY(), animals.toString());
    }
}
