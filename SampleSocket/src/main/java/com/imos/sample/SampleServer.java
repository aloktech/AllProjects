/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;

/**
 *
 * @author Pintu
 */
public class SampleServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8088);
            Socket socket = server.accept();
            InputStream stream;
            while (true) {
                if (socket.isClosed()) {
                    socket = server.accept();
                }
                stream = socket.getInputStream();
//                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            System.out.println(line);
//                        }
//                    }
                System.out.println(stream.getClass().getName());

//                    ObjectInputStream output = new ObjectInputStream(stream);
//                    try {
//                        Log4jLogEvent event;
//                        System.out.println(output.getClass().getName());
//                        while (output.available() > 0) {
//                            Object obj = output.readObject();
//                            System.out.println(obj.getClass().getSimpleName());
////                            System.out.println(event.getLevel());
////                            System.out.println(event.getMessage().getFormattedMessage());
////                            System.out.println(Arrays.asList(event.getMessage().getParameters()));
//                        }
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
            }

        } catch (IOException ex) {
            Logger.getLogger(SampleServer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SampleServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
