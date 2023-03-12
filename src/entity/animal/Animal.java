package entity.animal;

import util.AnimalFood;
import util.Reproducible;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.location.Location;
import resource.AnimalSetting;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public abstract class Animal implements AnimalFood, Reproducible {

    private final AnimalSetting animalSetting;

    protected Animal(AnimalSetting animalSetting) {
        this.animalSetting = animalSetting;
    }

    public final float getMaxOnSquare() {
        return animalSetting.maxOnSquare;
    }

    public final float getMaxMoveSize() {
        return animalSetting.maxMoves;
    }

    public abstract boolean isPredator();

    public void starve() {
        this.animalSetting.maxSatiety = this.animalSetting.maxSatiety - 0.5;
    }

    public AnimalSetting getAnimalSetting() {
        return animalSetting;
    }

    @Override
    public final boolean escapeFrom(Animal hunter) {
        final Map<Class<? extends Animal>, Short> huntersWithRiskFactor = getHuntersWithRiskFactor();
        if (huntersWithRiskFactor.isEmpty()) {
            return true;
        }

        final Short riskFactor = huntersWithRiskFactor.get(hunter.getClass());
        if (riskFactor != null) {
            // Count escape probability
            return riskFactor - ThreadLocalRandom.current().nextInt(0, 100) <= 0;
        } else {
            return true;
        }
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Short.shortValue()" because "riskFactor" is null
    }

    /**
     * @param food
     * @return true if food was eaten
     */
    public boolean tryToEat(AnimalFood food) {
        return !food.escapeFrom(this);
    }

    public Location chooseLocation(List<Location> locationList) {
        if (!locationList.isEmpty()) {
            return locationList.get(ThreadLocalRandom.current().nextInt(locationList.size()));
        } else {
            return null;
        }
    }

    @Override
    public final void pairSearch(Location location) {
        List<Animal> animals = location.getAnimals();
        Animal animal = animals.get(ThreadLocalRandom.current().nextInt(animals.size()));

        animals = location.copyListWithoutAnimal(animal);
        if (!isLocationFull(animal, animals)) {
            for (Animal pair : animals) {
                if (animal.equals(pair)) {
                    Animal pairObject = getPairObject(animal);
                    location.getAnimals().add(pairObject);
                    break;
                }
            }
        }
    }

    private Animal getPairObject(Animal animal) {
        return Stream.of(new Wolf(), new Python(), new Bear(), new Eagle(), new Fox(), new Boar(),
                        new Buffalo(), new Bunny(), new Caterpillar(),
                        new Deer(), new Duck(), new Goat(), new Horse(), new Mouse(), new Sheep()
                ).filter(x -> x.equals(animal))
                .findAny()
                .orElse(animal);


    }

    private boolean isLocationFull(Animal animal, List<Animal> animalList) {
        float maxOnSquare = animal.getMaxOnSquare();
        int count = 1;
        count += animalList.stream()
                .distinct()
                .count();

        if (count >= maxOnSquare) {
            return true;
        } else {
            return false;
        }
    }
}
