/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pintu
 */
public class SampleElasticSearch {

    public static void main(String[] args) {
        try {
            String connectionUrl = "http://192.168.1.34:8093";
            JestClientFactory factory = new JestClientFactory();
            factory.setHttpClientConfig(new HttpClientConfig.Builder(connectionUrl)
                    .multiThreaded(true)
                    .build());
            JestClient client = factory.getObject();

            String query = "{\n"
                    + " \"size\": 10000, \n"
                    + " \"query\" : {\n"
                    + " \"filtered\" : {\n"
                    + " \"filter\" : {\n"
                    + " \"range\" : {\n"
                    + " \"timeInMillis\" : {\n"
                    + " \"gte\" : "
                    + 10
                    + ",\n"
                    + " \"lt\" : "
                    + 100
                    + "\n"
                    + " }\n"
                    + " }\n"
                    + " }\n"
                    + " }\n"
                    + " },\n"
                    + " \"sort\": { \"timeInMillis\": { \"order\": \"asc\" }}\n"
                    + "}\n"
                    + "";
            String index = "temp-humid-db", type = "temp-humid";
            Search search = new Search.Builder(query)
                    .addIndex(index)
                    .addType(type)
                    .build();

            JestResult result = client.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException ex) {
            Logger.getLogger(SampleElasticSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
