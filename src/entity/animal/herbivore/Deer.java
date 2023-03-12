package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.Bear;
import entity.animal.predator.Wolf;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Deer extends Herbivore {
    public Deer() {
       super(new AnimalSetting(300, 20, 4, 50));
    }


    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 15);
            put(Bear.class, (short) 80);
        }};
        return huntersWithRiskFactor;
    }
}
