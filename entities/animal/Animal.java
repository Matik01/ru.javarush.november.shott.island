package entities.animal;

import entities.animal.herbivore.*;
import entities.animal.predator.*;
import entities.location.Location;
import resources.AnimalSetting;
import resources.SimulationSetting;
import util.Direction;
import util.Organism;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Organism {
    public abstract AnimalSetting getBaseSetting();

    public final Object[] move(Location location) {
        int coordX = location.getCoordX();
        int coordY = location.getCoordY();

        return chooseDirection(coordX, coordY);
    }

    private Object[] chooseDirection(int coordX, int coordY) {
        if (coordX - 1 >= 0) {
            return new Object[]{Direction.LEFT, coordX - 1, coordY};
        } else if (coordX + 1 <= SimulationSetting.getMaxX()) {
            return new Object[]{Direction.RIGHT, coordX + 1, coordY};
        } else if (coordY - 1 >= 0) {
            return new Object[]{Direction.UP, coordX, coordY - 1};
        } else if (coordY + 1 <= SimulationSetting.getMaxY()) {
            return new Object[]{Direction.DOWN, coordX, coordY + 1};
        }
        return null;
    }

    public final void reproduce(Location location) {
        ArrayList<Animal> animals = location.getAllAnimals();
        if (animals.size() > 1) {
            Animal animal = animals.get(0);
            ArrayList<Animal> newAllAnimals = location.getNewAllAnimals(animal);

            if (isReproducible(animal, newAllAnimals)) {
                pairSearch(animal, newAllAnimals, location);
            }
        }
    }

    private <T extends Animal> void pairSearch(T animal, ArrayList<T> pairList, Location location) {
        for (T pair : pairList) {
            if (animal.equals(pair) && pair instanceof Predator) {
                Predator predator = pairSearchPredator(animal);
                location.getAllAnimals().add(predator);
                location.getPredators().add(predator);
            } else if (animal.equals(pair) && pair instanceof Herbivore) {
                Herbivore herbivore = pairSearchHerbivore(animal);
                location.getAllAnimals().add(herbivore);
                location.getHerbivores().add(herbivore);
            }
        }
    }

    private Predator pairSearchPredator(Animal animal) {
        Predator predator = (Predator) animal;
        ArrayList<Predator> listOfAnimals = new ArrayList<>(List.of(new Wolf(), new Python(), new Bear(), new Eagle(), new Fox()));
        for (Predator list : listOfAnimals) {
            if (predator.equals(list)) {
                return list;
            }
        }
        return null;
    }

    private Herbivore pairSearchHerbivore(Animal animal) {
        Herbivore herbivore = (Herbivore) animal;
        ArrayList<Herbivore> listOfAnimals = new ArrayList<>(List.of(new Boar(), new Buffalo(), new Bunny(), new Caterpillar(),
                new Deer(), new Duck(), new Goat(), new Horse(), new Mouse(), new Sheep()));
        for (Herbivore list : listOfAnimals) {
            if (herbivore.equals(list)) {
                return list;
            }
        }
        return null;
    }

    private boolean isReproducible(Animal animal, ArrayList<Animal> animalList) {
        int maxOnSquare = animal.getBaseSetting().getMaxOnSquare();
        int count = 1;
        for (Animal pair : animalList) {
            if (animal.equals(pair)) {
                count++;
            }
        }
        if (count >= maxOnSquare) {
            return false;
        } else {
            return true;
        }
    }

    public final <T extends Animal> void dying(Location location) {
        location.getAllAnimals().remove(this);
    }

}