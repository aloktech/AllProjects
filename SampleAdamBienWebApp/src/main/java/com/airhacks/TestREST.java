/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author alok
 */
@Path("test")
public class TestREST {

    @GET
    public String getString() {
        return "OK working " + System.currentTimeMillis();
    }
}
