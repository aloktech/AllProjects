/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

/**
 *
 * @author Pintu
 */
public class Multiplier {

    private final long factor;
    private final Deferred<Long, Long, String> deferred = new DeferredObject<>();

    public Multiplier(long factor) {
        this.factor = factor;
    }

    public long multiplyNTimes(int rounds) {
        long result = 1;
        for (int i = 1; i <= rounds; i++) {
            deferred.notify("status: " + (i * 100 / rounds) + "%");
            result *= factor;
        }
        deferred.resolve(result);
        return result;
    }

    public Promise<Long, Long, String> promise() {
        return deferred.promise();
    }
    
    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier(100);
        multiplier.multiplyNTimes(10);
        multiplier.promise();
        System.out.println(multiplier.promise());
    }
}
