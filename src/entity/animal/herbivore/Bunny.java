package entity.animal.herbivore;

import resource.AnimalSetting;

import java.util.Objects;

public class Bunny extends Herbivore {
    private AnimalSetting baseSetting;
    private int caterpillarToEat;
    public Bunny(){
        this.baseSetting = AnimalSetting.getBunnyBaseSettings();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bunny bunny = (Bunny) o;
        return Objects.equals(baseSetting, bunny.baseSetting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseSetting);
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
    public String toString() {
        return "Bunny{}";
    }
}
