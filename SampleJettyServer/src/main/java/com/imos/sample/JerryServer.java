package com.imos.sample;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pintu
 */
public class JerryServer {

    public static void main(String[] args) {

        ResourceConfig config = new ResourceConfig();
        config.packages("com.imos.sample");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");
        context.addFilter(CORSFilter.class, "/*", null);

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(JerryServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            server.destroy();
        }

    }
}
