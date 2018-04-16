///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.imos.sample;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.lightcouch.CouchDbClient;
//
///**
// *
// * @author Pintu
// */
//public class SampleCouchDB {
//
//    public static void main(String[] args) {
//        try {
//            CouchDbClient dbClient = new CouchDbClient("logdb", false, "http", "localhost", 5984, "admin", "admin");
//            InputStream input = dbClient.find("ef274a932a2842a7b037fe183cccf38b");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while((line = reader.readLine()) != null) {
//                builder.append(line);
//            }
//            System.out.println(builder.toString());
//        } catch (IOException ex) {
//            Logger.getLogger(SampleCouchDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
