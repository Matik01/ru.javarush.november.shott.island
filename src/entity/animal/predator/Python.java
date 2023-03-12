package entity.animal.predator;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import resource.AnimalSetting;
import entity.animal.predator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Python extends Predator {
    public Python() {
        super(new AnimalSetting(15, 30, 1, 3));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Bear.class, (short) 20);
        }};

        return huntersWithRiskFactor;
    }
}
