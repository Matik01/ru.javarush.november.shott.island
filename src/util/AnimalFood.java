package util;

import entity.animal.Animal;
import java.util.Map;

public interface AnimalFood {
    /**
     * @param hunter
     * @return true if escaped
     */
    boolean escapeFrom(Animal hunter);

    Map<Class<? extends Animal>, Short> getHuntersWithRiskFactor();

}
