/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.stream.IntStream;
import org.jdeferred.DonePipe;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

/**
 *
 * @author Pintu
 */
public class PipeExample {

    public static void main(String[] args) {
        IntStream.of(4, 1, 3).forEach(i -> {
            Multiplier m = new Multiplier(5);
            Promise<Long, Long, String> promise = m.promise().progress(System.out::println)
                    .done((res) -> System.out.println("the result is: " + res));
            promise.then((DonePipe<Long, Long, Exception, String>) (Long result) -> {
                if (result < 50) {
                    System.out.println("result < 50, that's too low -> error");
                    return new DeferredObject<Long, Exception, String>().reject(new Exception("result too low"));
                }
                if (result < 130) {
                    System.out.println("result < 130, doubling the value..");
                    return new DeferredObject<Long, Exception, String>().resolve(result * 2);
                }
                return new DeferredObject<Long, Exception, String>().resolve(result);
            }).fail((exception) -> System.err.println("error: " + exception.getMessage()))
                    .done((result) -> System.out.println("pipe result: " + result));
            m.multiplyNTimes(i);
        });
    }
}
