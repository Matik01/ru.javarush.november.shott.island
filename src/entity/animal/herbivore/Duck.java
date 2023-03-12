package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Duck extends Herbivore {

    public Duck(){
        super(new AnimalSetting(1, 200, 4, 0.15));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        final Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 40);
            put(Python.class, (short) 10);
            put(Fox.class, (short) 60);
            put(Bear.class, (short) 10);
            put(Eagle.class, (short) 80);
        }};
        return huntersWithRiskFactor;
    }
}
