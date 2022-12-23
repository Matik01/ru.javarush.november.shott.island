package entities.plant;

import util.Organism;

public class Plant implements Organism {
    private int maxOnSquare  = 200;
    private int plantMass = 1;

    public int getPlantMass() {
        return plantMass;
    }

    public int getMaxOnSquare() {
        return maxOnSquare;
    }
}
