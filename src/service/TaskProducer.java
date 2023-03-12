package service;

import entity.location.Location;
import resource.SimulationSetting;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


public class TaskProducer implements Runnable {
    private ConcurrentLinkedQueue<LocationTask> taskQueue;
    private final List<Location> island;

    public TaskProducer(ConcurrentLinkedQueue<LocationTask> taskQueue) {
        this.taskQueue = taskQueue;
        this.island = SimulationSetting.getIsland();
    }

    @Override
    public void run() {
        island.parallelStream()
                .forEach(location -> taskQueue.add(new LocationTask(location)));

    }
}




