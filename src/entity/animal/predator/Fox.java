package entity.animal.predator;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import resource.AnimalSetting;
import entity.animal.predator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fox extends Predator {

    public Fox() {
        super(new AnimalSetting(8, 30 , 2, 2));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap(){
            {
                put(Python.class, (short) 15);
                put(Eagle.class, (short) 10);
            }
        };
        return huntersWithRiskFactor;
    }
}
