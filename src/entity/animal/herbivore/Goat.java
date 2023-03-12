package entity.animal.herbivore;


import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Goat extends Herbivore {

    public Goat(){
       super(new AnimalSetting(60, 140, 3, 10));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 60);
            put(Bear.class, (short) 70);
        }};
        return huntersWithRiskFactor;
    }
}
