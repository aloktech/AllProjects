/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Pintu
 */
@Path("basic")
public class BasicRESTService {

    @GET
    public String getMessage() {
        return "OK done : " + System.currentTimeMillis();
    }
}
