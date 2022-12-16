package animals.predators;

import animals.Animal;
import location.Location;
import resources.AnimalSetting;
import animals.Predator;

import java.util.Objects;

public class Wolf extends Predator {
    private AnimalSetting baseSetting;
    private int satiety = 0;
    private int moves = 0;

    public Wolf() {
        this.baseSetting = AnimalSetting.getWolfBaseSettings();
    }

    @Override
    public void eat(Animal animal) {

    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void dying() {

    }

    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return satiety == wolf.satiety && moves == wolf.moves && Objects.equals(baseSetting, wolf.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting, satiety, moves);
    }
}
