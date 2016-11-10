/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author alok
 */
public class InvalidJSONDataException extends Exception {

    public InvalidJSONDataException() {
    }

    public InvalidJSONDataException(String message) {
        super(message);
    }

    public InvalidJSONDataException(Throwable throwable) {
        super(throwable);
    }
}
