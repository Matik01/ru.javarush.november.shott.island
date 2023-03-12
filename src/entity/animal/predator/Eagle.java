package entity.animal.predator;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import resource.AnimalSetting;
import entity.animal.predator.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Eagle extends Predator {

    public Eagle(){
        super( new AnimalSetting(6, 20, 3, 1));
    }


    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        return Collections.emptyMap();
    }
}
