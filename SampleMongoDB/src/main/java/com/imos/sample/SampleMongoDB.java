/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.json.JSONObject;

/**
 *
 * @author Pintu
 */
public class SampleMongoDB {

    public static void main(String[] args) {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        MongoCollection<Document> collection = database.getCollection("sampleLog");
        System.out.println(collection.count());
        MongoCursor<Document> cursor = collection.find().iterator();
        ObjectMapper mapper = new ObjectMapper();
        try {
            while (cursor.hasNext()) {
                try {
                    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cursor.next()));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(SampleMongoDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            cursor.close();
        }
    }

    private static void sampleOne(MongoDatabase database) throws JsonProcessingException {
        MongoCollection<Document> collection = database.getCollection("test");
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
//        collection.insertOne(doc);
        System.out.println(collection.count());
        MongoCursor<Document> cursor = collection.find().iterator();
        ObjectMapper mapper = new ObjectMapper();
//        try {
//            while (cursor.hasNext()) {
////                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cursor.next()));
//            }
//        } finally {
//            cursor.close();
//        }

        Document myDoc = collection.find(eq("type", "database")).first();
        System.out.println(myDoc.toJson());
    }
}
