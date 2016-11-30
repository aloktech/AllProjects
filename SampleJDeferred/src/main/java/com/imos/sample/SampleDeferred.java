/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.jdeferred.DoneFilter;
import org.jdeferred.Promise;

import org.jdeferred.Promise.State;

import org.jdeferred.impl.DeferredObject;

/**
 *
 * @author Pintu
 */
public class SampleDeferred {

    public static void main(String[] args) {
        Deferred deferred = new DeferredObject();
        Promise promise = deferred.promise();
        promise.then(d -> {
            System.out.println("then : " + d);
        }).done(r -> {
            System.out.println("done : " + r);
        }).fail(r -> {
            System.out.println("fail :" + r);
        }).progress(p -> {
            System.out.println("progress : " + p);
        }).always((State state, Object result, Object rejection) -> {
            System.out.println("alway");
        });

        deferred.resolve("done1");
//        deferred.reject("oops");
//        deferred.notify("100%");

        Promise p = deferred.promise();
        Promise filtered = p.then(new DoneFilter<Integer, Integer>() {
            @Override
            public Integer filterDone(Integer result) {
                return 1;
            }
        });

        filtered.done(new DoneCallback<Integer>() {

            @Override
            public void onDone(Integer result) {
                // result would be original * 10
                System.out.println(result);
            }
        }
        );
//        d.resolve(3) -> 30;
        deferred.resolve("2");
    }
}
