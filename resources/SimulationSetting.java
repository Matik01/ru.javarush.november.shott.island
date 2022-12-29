package resources;

public class SimulationSetting {
    private static int maxX;
    private static int maxY;
    private static int SIMULATION_DURATION;
    private static int CORE_SIZE = 8;
    private static int GAME_DURATION;

    public void setGameDuration(int gameDuration) {
        GAME_DURATION = gameDuration;
    }

    public static int getGameDuration() {
        return GAME_DURATION;
    }

    public void setCoreSize(int coreSize) {
        CORE_SIZE = coreSize;
    }

    public static int getCoreSize() {
        return CORE_SIZE;
    }

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
