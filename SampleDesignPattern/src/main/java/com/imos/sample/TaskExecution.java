/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 * @param <T>
 * @param <S>
 */
public class TaskExecution<T, S> implements IExecute<T, S> {

    private final ITask<T, S> task;

    public TaskExecution(ITask<T, S> task) {
        this.task = task;
    }

    @Override
    public void configure() {
        try {
            task.configure();
        } catch (Exception e) {
            task.errorHandling(e);
        }
    }

    @Override
    public S execute(T input) {
        S result = null;
        try {
            task.open();
            result = task.execute(input);
        } catch (Exception e) {
            task.errorHandling(e);
        } finally {
            task.close();
        }
        return result;
    }

}
