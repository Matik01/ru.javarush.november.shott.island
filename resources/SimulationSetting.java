package resources;

public class SimulationSetting {
    private static int maxX;
    private static int maxY;
    boolean isExctinct;

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxY() {
        return maxY;
    }
}
