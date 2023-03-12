package entity.animal.predator;

import entity.animal.Animal;
import resource.AnimalSetting;

import java.util.Collections;
import java.util.Map;

public final class Wolf extends Predator {

    public Wolf() {
        super(new AnimalSetting(50,30,3,8));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        return Collections.emptyMap();
    }
}
