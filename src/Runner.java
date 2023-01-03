
import resource.LocationSetting;
import service.GameWorker;

public class Runner {
    public static void main(String[] args) {
        LocationSetting locationSetting = new LocationSetting();
        locationSetting.run();
        GameWorker gameWorker = new GameWorker(locationSetting);
        gameWorker.start();
    }
}
