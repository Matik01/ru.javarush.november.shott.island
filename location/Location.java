package location;

import animal.Animal;
import animal.Herbivore;
import animal.Predator;
import plant.Plant;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private int coordX;
    private int coordY;
    private ArrayList<Predator> predators = new ArrayList<>();
    private ArrayList<Herbivore> herbivores = new ArrayList<>();
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

}
