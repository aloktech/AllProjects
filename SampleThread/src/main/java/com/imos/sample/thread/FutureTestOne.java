/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alok
 */
public class FutureTestOne {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new FutureTestOne().test();
    }

    private void test() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<TestClass> f = CompletableFuture.supplyAsync(() -> executeTask("T1"), executor);

        System.out.println("Is task completed 1 [" + f.isDone() + "]");

        f.thenApplyAsync(t -> {
            System.out.println("Inside then apply async [" + Thread.currentThread().getName() + "]");
            return "";
        }, executor);

        System.out.println("Is task completed 2 [" + f.isDone() + "]");

        f.whenComplete((t, e) -> {
            System.out.println("Inside when complete [" + Thread.currentThread().getName() + "]");
            System.out.println(t + " : " + e);
        });

        System.out.println("Is task completed 3 [" + f.isDone() + "]");

        f.thenApply(t -> {
            System.out.println("Inside then apply [" + Thread.currentThread().getName() + "]");
            return "";
        });

        System.out.println("Main thread completed");
    }

    private TestClass executeTask(String name) {
        System.out.println("Inside task [" + name + "] thead[" + Thread.currentThread().getName() + "]");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Task execution complete");
        return new TestClass(name);
    }

}
