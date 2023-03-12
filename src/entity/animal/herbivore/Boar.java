package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Boar extends Herbivore {
    public Boar(){
        super(new AnimalSetting(400, 50, 2, 50));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 15);
            put(Bear.class, (short) 50);
        }};
        return huntersWithRiskFactor;
    }
}
