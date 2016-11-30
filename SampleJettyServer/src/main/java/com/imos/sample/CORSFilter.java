/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pintu
 */
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletResponse httpResponse = ((HttpServletResponse) response);
        httpResponse.addHeader("Access-Control-Allow-Methods", "API, CRUNCHIFYGET, GET, POST, PUT, UPDATE, OPTIONS");
        httpResponse.addHeader("Access-Control-Max-Age", "151200");
        httpResponse.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestHeader = httpRequest.getHeader("Access-Control-Request-Headers");
        if (null != requestHeader && !requestHeader.equals(null)) {
            httpResponse.addHeader("Access-Control-Allow-Headers", requestHeader);
        }
        
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
