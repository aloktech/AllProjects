/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.rest;

import com.imos.sample.IAction;
import com.imos.sample.TestAction;
import com.imos.sample.TestJSON;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author alok
 */
@Path("test")
public class TestREST {

    @GET
    public String getString() {
        IAction ta = new TestAction();
        ta.execute();
        return "OK working " + System.currentTimeMillis();
    }

    @POST
    public Response test(TestJSON data) {
        return Response.status(0).build();
    }
}
