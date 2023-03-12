package resource;

import entity.location.Location;

import java.util.ArrayList;
import java.util.List;

public class SimulationSetting {
    private static int maxX = 5;
    private static int maxY = 5;
    private static int SIMULATION_DURATION = 2000;
    private static int CORE_SIZE = 7;
    private static int GAME_DURATION = 30000;
    private static List<Location> island = new ArrayList<>();

    public static synchronized List<Location> getIsland() {
        return island;
    }

    public static int getGameDuration() {
        return GAME_DURATION;
    }

    public static int getCoreSize() {
        return CORE_SIZE;
    }

    public static int getSimulationDuration() {
        return SIMULATION_DURATION;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxY() {
        return maxY;
    }
}
