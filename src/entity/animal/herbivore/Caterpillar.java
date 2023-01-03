package entity.animal.herbivore;

import resource.AnimalSetting;

import java.util.Objects;

public class Caterpillar extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;
    public Caterpillar(){
        this.baseSetting = AnimalSetting.getCaterpillarBaseSettings();
    }


    @Override
    public AnimalSetting getBaseSetting() {
        return baseSetting;
    }

    @Override
    public int getCaterpillarToEat() {
        return caterpillarToEat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caterpillar that = (Caterpillar) o;
        return Objects.equals(baseSetting, that.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
    }

    @Override
    public String toString() {
        return "Caterpillar{}";
    }
}
