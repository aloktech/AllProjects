/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.rest;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Pintu
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {
         
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, PUT, DELETE, POST, OPTIONS");
        headers.add("Access-Control-Allow-Credentials", "true");

        String reqHead = requestContext.getHeaderString("Access-Control-Request-Headers");
        if (reqHead != null) {
            headers.add("Access-Control-Allow-Headers", reqHead);
        }
    }
}