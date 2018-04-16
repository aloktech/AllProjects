/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.exception;

/**
 *
 * @author Pintu
 */
public class ExecutionException extends Exception {

    private static final long serialVersionUID = -2180206966339301926L;

    public ExecutionException(String msg) {
        super(msg);
    }

    public ExecutionException(Exception e) {
        super(e);
    }

    public ExecutionException(String msg, Exception e) {
        super(msg, e);
    }
}
