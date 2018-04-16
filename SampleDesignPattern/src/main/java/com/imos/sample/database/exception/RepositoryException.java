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
public class RepositoryException extends Exception {

    private static final long serialVersionUID = -2180206966339301926L;

    public RepositoryException(String msg) {
        super(msg);
    }

    public RepositoryException(Exception e) {
        super(e);
    }

    public RepositoryException(String msg, Exception e) {
        super(msg, e);
    }
}
