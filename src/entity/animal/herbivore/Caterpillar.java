package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Caterpillar extends Herbivore {

    public Caterpillar(){
        super(new AnimalSetting(0.01, 1000, 0, 0));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Fox.class, (short) 40);
            put(Mouse.class, (short) 90);
            put(Boar.class, (short) 90);
            put(Duck.class, (short) 90);
        }};
        return huntersWithRiskFactor;
    }
}
