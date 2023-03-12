package service;

import entity.animal.Animal;
import entity.location.Location;
import resource.SimulationSetting;

import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class GameWorker {
    private TaskProducer taskProducer;
    private TaskConsumer taskConsumer;
    private ConcurrentLinkedQueue<LocationTask> taskQueue = new ConcurrentLinkedQueue<>();

    public GameWorker() {
        this.taskProducer = new TaskProducer(taskQueue);
        this.taskConsumer = new TaskConsumer(taskQueue);
    }

    public void start() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(taskProducer);
        for (int i = 0; i < 4; i++) {
            service.scheduleAtFixedRate(taskConsumer, 1000, SimulationSetting.getSimulationDuration(), TimeUnit.MILLISECONDS);
        }

        Runnable cancelTask = () ->{
            service.shutdown();
            executorService.shutdown();
        };
        service.schedule(cancelTask, SimulationSetting.getGameDuration(), TimeUnit.MILLISECONDS);




    }


}

