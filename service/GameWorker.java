package service;

import entity.location.Location;
import resource.LocationSetting;
import resource.SimulationSetting;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.*;

public class GameWorker extends Thread {
    private LocationSetting locationSetting;
    private SimulationProcess simulationProcess;
    private ArrayList<Location> island;
    private final int CORE_SIZE = SimulationSetting.getCoreSize();

    public GameWorker(LocationSetting locationSetting) {
        this.locationSetting = locationSetting;
        this.island = locationSetting.getIsland();
    }

    @Override
    public void run() {
        locationSetting.simulationStatistics();

        simulationProcess = new SimulationProcess(locationSetting.getIsland());
        ScheduledExecutorService singleExecutor = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_SIZE);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                executorService.shutdown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                locationSetting.simulationStatistics();
                singleExecutor.shutdown();
            }
        };
        singleExecutor.schedule(runnable, SimulationSetting.getGameDuration(), TimeUnit.MILLISECONDS);

        for (int i = 0; i < CORE_SIZE; i++) {
            executorService.scheduleWithFixedDelay(this::locationRun, 0, locationSetting.getSimulationDuration(), TimeUnit.MILLISECONDS);
        }

    }


    private void locationRun() {
        synchronized (island) {
            Location location = island.get(ThreadLocalRandom.current().nextInt(island.size()));
            location.getLock().lock();
            try {
                simulationProcess.setLocation(location);
                simulationProcess.run();
                location.getLocationStatistics();
                System.out.println();
                System.out.println("---------------------------------------------------------");
            } finally {
                location.getLock().unlock();
            }
        }

    }


}
