/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Arrays.asList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Pintu
 */
public class NewClass {

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("test");

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

            Document address = new Document()
                    .append("street", "2 Avenue")
                    .append("zipcode", "10075")
                    .append("building", "1480")
                    .append("coord", asList(-73.9557413, 40.7720266));

            db.getCollection("restaurants").insertOne(
                    new Document("address",
                            address)
                            .append("borough", "Manhattan")
                            .append("cuisine", "Italian")
                            .append("grades", asList(
                                    new Document()
                                            .append("date", format.parse("2014-10-01T00:00:00Z"))
                                            .append("grade", "A")
                                            .append("score", 11),
                                    new Document()
                                            .append("date", format.parse("2014-01-16T00:00:00Z"))
                                            .append("grade", "B")
                                            .append("score", 17)))
                            .append("name", "Vella")
                            .append("restaurant_id", "41704620"));

            FindIterable<Document> iterable = db.getCollection("restaurants").find();

            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                }
            });

            db.getCollection("restaurants").updateOne(address, new Document()
//                    .append("street", "5th Avenue")
                    .append("zipcode", "10075")
                    .append("building", "1480")
                    .append("coord", asList(-73.9557413, 40.7720266)));

            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                }
            });

        } catch (ParseException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
