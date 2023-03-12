package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;

import java.util.HashMap;
import java.util.Map;

public class Sheep extends Herbivore {

    public Sheep(){
        super(new AnimalSetting(70,140, 3, 15));
    }


    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 70);
            put(Bear.class, (short) 70);
        }};
        return huntersWithRiskFactor;
    }

}
