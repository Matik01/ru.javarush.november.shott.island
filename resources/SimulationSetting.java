package resources;

public class SimulationSetting {
    private static int maxX;
    private static int maxY;
    private static int SIMULATION_DURATION;

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setSimulationDuration(int simulationDuration) {
        SIMULATION_DURATION = simulationDuration;
    }

    public int getSimulationDuration() {
        return SIMULATION_DURATION;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxY() {
        return maxY;
    }
}
