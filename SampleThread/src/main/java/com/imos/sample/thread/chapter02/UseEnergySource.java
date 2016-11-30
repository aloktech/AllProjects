/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alok
 */

public class UseEnergySource {
  public static void main(String[] args) throws Exception {
    final EnergySource energySource = new EnergySource();

    ExecutorService executorService = Executors.newFixedThreadPool(50);

    for(int i = 0; i < 50; i++) {
      executorService.execute(() -> energySource.useEnergy(1));
    }
    executorService.shutdown();

    Thread.sleep(1000);
    System.out.println("Available: " + energySource.getUnitsAvailable());
    energySource.stopEnergySource();
  }
}
