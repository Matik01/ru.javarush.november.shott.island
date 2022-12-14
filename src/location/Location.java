package location;

import animals.Animal;
import plants.Plant;
import java.util.HashMap;

public class Location {
    private int coordX;
    private int coordY;
    private HashMap<Animal, Integer> animalCount= new HashMap<>();
    private HashMap<Plant, Integer> plantCount = new HashMap<>();

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

    public HashMap<Plant, Integer> getPlantCount() {
        return plantCount;
    }

    public HashMap<Animal, Integer> getAnimalCount() {
        return animalCount;
    }

}
