package entity.plant;

import resource.PlantSetting;
import util.AnimalFood;
import entity.animal.Animal;
import entity.animal.herbivore.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Plant implements AnimalFood {
    private final PlantSetting plantSetting;

    public Plant() {
        this.plantSetting = new PlantSetting(200, 1);
    }

    public final int getMaxOnSquare() {
        return plantSetting.maxOnSquare;
    }

    public final int getPlantMass() {
        return plantSetting.plantMass;
    }

    @Override
    public boolean escapeFrom(Animal hunter) {
        final Map<Class<? extends Animal>, Short> huntersWithRiskFactor = getHuntersWithRiskFactor();
        if (huntersWithRiskFactor.isEmpty()) {
            return true;
        }

        final Short riskFactor = huntersWithRiskFactor.get(hunter.getClass());
        // Count escape probability
        return riskFactor - ThreadLocalRandom.current().nextInt(0, 100) <= 0;
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        final Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Horse.class, (short) 100);
            put(Bunny.class, (short) 100);
            put(Boar.class, (short) 100);
            put(Buffalo.class, (short) 100);
            put(Caterpillar.class, (short) 100);
            put(Deer.class, (short) 100);
            put(Duck.class, (short) 100);
            put(Goat.class, (short) 100);
            put(Mouse.class, (short) 100);
            put(Sheep.class, (short) 100);
        }};

        return huntersWithRiskFactor;
    }
}
