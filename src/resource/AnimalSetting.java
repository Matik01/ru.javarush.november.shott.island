package resource;

public final class AnimalSetting {
    public final double animalMass;
    public final int maxOnSquare;
    public final int maxMoves;
    public double maxSatiety;

    public AnimalSetting(double animalMass, int maxOnSquare, int maxMoves, double maxSatiety){
        this.animalMass = animalMass;
        this.maxOnSquare = maxOnSquare;
        this.maxMoves = maxMoves;
        this.maxSatiety = maxSatiety;
    }
}
