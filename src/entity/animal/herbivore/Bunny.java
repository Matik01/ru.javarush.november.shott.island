package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bunny extends Herbivore {
    public Bunny() {
        super(new AnimalSetting(2, 150, 2, 0.45));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 60);
            put(Python.class, (short) 20);
            put(Fox.class, (short) 70);
            put(Bear.class, (short) 80);
            put(Eagle.class, (short) 90);
        }};
        return huntersWithRiskFactor;
    }
}
