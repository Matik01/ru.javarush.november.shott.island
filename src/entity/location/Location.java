package entity.location;

import entity.animal.Animal;
import entity.plant.Plant;
import util.AnimalFood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Location {
    private int coordX;
    private int coordY;
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

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

    public List<Plant> getPlants() {
        return plants;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getPredatorAnimals() {
        return animals.stream().filter(Animal::isPredator).collect(Collectors.toList());
    }

    public List<Animal> getHerbivoreAnimals() {
        return animals.stream().filter(a -> !a.isPredator()).collect(Collectors.toList());
    }

    public List<Animal> copyListWithoutAnimal(Animal animal) {
        List<Animal> copyAnimals = new ArrayList<>(List.copyOf(this.animals));
        copyAnimals.remove(animal);
        return copyAnimals;
    }

    public final void dying(AnimalFood animalFood) {
        if (animalFood instanceof Animal) {
            this.getAnimals().remove(animalFood);
        } else if (animalFood instanceof Plant) {
            this.getPlants().remove(animalFood);
        }
    }
}
