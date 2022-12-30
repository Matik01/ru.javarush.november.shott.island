package resource;

public final class AnimalSetting {
    private double animalMass;
    private int maxOnSquare;
    private int maxMoves;
    private double maxSatiety;
    private static AnimalSetting WOLF_BASE_SETTINGS = new AnimalSetting(50, 30, 3, 8);
    private static AnimalSetting PYTHON_BASE_SETTINGS = new AnimalSetting(15, 30, 1, 3);
    private static AnimalSetting FOX_BASE_SETTINGS = new AnimalSetting(8, 30 , 2, 2);
    private static AnimalSetting BEAR_BASE_SETTINGS = new AnimalSetting(500, 5,2, 80);
    private static AnimalSetting EAGLE_BASE_SETTINGS = new AnimalSetting(6, 20, 3, 1);
    private static AnimalSetting HORSE_BASE_SETTINGS = new AnimalSetting(400, 20, 4, 60);
    private static AnimalSetting DEER_BASE_SETTINGS = new AnimalSetting(300, 20, 4, 50);
    private static AnimalSetting BUNNY_BASE_SETTINGS = new AnimalSetting(2, 150, 2, 0.45);
    private static AnimalSetting MOUSE_BASE_SETTINGS = new AnimalSetting(0.05, 500, 1, 0.01);
    private static AnimalSetting GOAT_BASE_SETTINGS = new AnimalSetting(60, 140, 3, 10);
    private static AnimalSetting SHEEP_BASE_SETTINGS = new AnimalSetting(70,140, 3, 15);
    private static AnimalSetting BOAR_BASE_SETTINGS = new AnimalSetting(400, 50, 2, 50);
    private static AnimalSetting BUFFALO_BASE_SETTINGS = new AnimalSetting(700, 10, 3, 100);
    private static AnimalSetting DUCK_BASE_SETTINGS = new AnimalSetting(1, 200, 4, 0.15);
    private static AnimalSetting CATERPILLAR_BASE_SETTINGS = new AnimalSetting(0.01, 1000, 0, 0);

    private AnimalSetting(double animalMass, int maxOnSquare, int maxMoves, double maxSatiety){
        this.animalMass = animalMass;
        this.maxOnSquare = maxOnSquare;
        this.maxMoves = maxMoves;
        this.maxSatiety = maxSatiety;
    }

    public static AnimalSetting getCaterpillarBaseSettings() {
        return CATERPILLAR_BASE_SETTINGS;
    }

    public static AnimalSetting getDuckBaseSettings() {
        return DUCK_BASE_SETTINGS;
    }

    public static AnimalSetting getBuffaloBaseSettings() {
        return BUFFALO_BASE_SETTINGS;
    }

    public static AnimalSetting getBoarBaseSettings() {
        return BOAR_BASE_SETTINGS;
    }

    public static AnimalSetting getSheepBaseSettings() {
        return SHEEP_BASE_SETTINGS;
    }

    public static AnimalSetting getGoatBaseSettings() {
        return GOAT_BASE_SETTINGS;
    }

    public static AnimalSetting getMouseBaseSettings() {
        return MOUSE_BASE_SETTINGS;
    }

    public static AnimalSetting getBunnyBaseSettings() {
        return BUNNY_BASE_SETTINGS;
    }

    public static AnimalSetting getDeerBaseSettings() {
        return DEER_BASE_SETTINGS;
    }

    public static AnimalSetting getHorseBaseSettings() {
        return HORSE_BASE_SETTINGS;
    }

    public static AnimalSetting getEagleBaseSettings() {
        return EAGLE_BASE_SETTINGS;
    }

    public static AnimalSetting getBearBaseSettings() {
        return BEAR_BASE_SETTINGS;
    }

    public static AnimalSetting getFoxBaseSettings() {
        return FOX_BASE_SETTINGS;
    }

    public static AnimalSetting getWolfBaseSettings(){
        return WOLF_BASE_SETTINGS;
    }

    public static AnimalSetting getPythonBaseSettings() {
        return PYTHON_BASE_SETTINGS;
    }

    public double getAnimalMass() {
        return animalMass;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    public int getMaxOnSquare() {
        return maxOnSquare;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public void setMaxMoves(int maxMoves) {
        this.maxMoves = maxMoves;
    }
}
