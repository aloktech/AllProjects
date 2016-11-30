/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.rest;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author Pintu
 */
@Path("basic")
public class BasicRESTService  {
    
    @GET
    @Path("name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getName() {
        JSONObject result = new JSONObject();
        result.put("status", "OK");
        result.put("time", new Date());
        return Response.ok()
                .entity(result.toString())
                .build();
    }
}
