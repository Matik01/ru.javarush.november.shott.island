package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.Bear;
import entity.animal.predator.Wolf;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Horse extends Herbivore {
    public Horse(){
        super(new AnimalSetting(400, 20, 4, 60));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 10);
            put(Bear.class, (short) 40);
        }};
        return huntersWithRiskFactor;
    }


}
