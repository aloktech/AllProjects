package com.imos.sample;

/**
 *
 * @author Pintu
 * @param <M>
 * @param <E>
 */
@FunctionalInterface
public interface ExceptionFunction<M, E extends Exception> {

    Object accept(M m) throws E;
}
