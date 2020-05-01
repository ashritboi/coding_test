package com.kuebiko.it.design.farm;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FarmRunner {

  private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

  public static void main(String[] args) throws IOException {

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Bird myChicken = new Chicken("potent hen");
    Bird myDuck  = new Duck("Golden Duck");

   //scheduler.scheduleAtFixedRate(() -> {simulate(myChicken); simulate((myDuck));}, 2, 10 , TimeUnit.SECONDS);


   scheduler.scheduleAtFixedRate(() -> simulate(myChicken), 2, 1 , TimeUnit.SECONDS);
   scheduler.scheduleAtFixedRate(() -> simulate(myDuck), 1, 2 ,TimeUnit.SECONDS);

  }

  static void simulate(Bird bird) {
    executorService.submit(bird::lay);
  }

}
