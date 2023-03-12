package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mouse extends Herbivore {

    public Mouse(){
        super(new AnimalSetting(0.05, 500, 1, 0.01));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 80);
            put(Python.class, (short) 40);
            put(Fox.class, (short) 90);
            put(Bear.class, (short) 90);
            put(Eagle.class, (short) 90);
            put(Boar.class, (short) 50);
        }};
        return huntersWithRiskFactor;
    }
}
