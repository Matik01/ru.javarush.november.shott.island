package entity.animal.herbivore;

import entity.animal.Animal;
import entity.animal.predator.*;
import resource.AnimalSetting;
import java.util.HashMap;
import java.util.Map;
public class Buffalo extends Herbivore {

    public Buffalo(){
        super(new AnimalSetting(700, 10, 3, 100));
    }

    @Override
    public Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor() {
        Map<Class<? extends Animal>, Short> huntersWithRiskFactor = new HashMap<>() {{
            put(Wolf.class, (short) 10);
            put(Bear.class, (short) 20);
        }};
        return huntersWithRiskFactor;
    }
}
