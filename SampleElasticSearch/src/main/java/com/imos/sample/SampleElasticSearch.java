/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import java.io.IOException;

/**
 *
 * @author alok
 */
public class SampleElasticSearch {

    public static void main(String[] args) throws IOException {
//        String connectionUrl = "http://172.17.0.1:9300";
        String connectionUrl = "http://localhost:9200";
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder(connectionUrl)
                .multiThreaded(true)
                .build());
        JestClient client = factory.getObject();

        client.execute(new CreateIndex.Builder("articles").build());

        Article source = new Article();
        source.setAuthor("John Ronald Reuel Tolkien");
        source.setContent("The Lord of the Rings is an epic high fantasy novel");

        Index index = new Index.Builder(source).index("articles").type("article").build();
//        client.execute(index);
        
//        client.execute(new DeleteIndex.Builder(source)
//                .type("article")
//                .setParameter("_id", "AVf7HvzQs85IMGWCrAA5")
//                .build());
        
        String query = "{\n"
                + "    \"query\": {\n"
                + "        \"filtered\" : {\n"
                + "            \"query\" : {\n"
                + "                \"query_string\" : {\n"
                + "                    \"query\" : \"Lord\"\n"
                + "                }\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "}";

        Search search = (Search) new Search.Builder(query)
                // multiple index or types can be added.
                .addIndex("articles")
                .addType("article")
                .build();

        JestResult result = client.execute(search);
        
        ObjectMapper mapper =new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        System.out.println(mapper.writeValueAsString(result.getJsonString()));
        System.out.println(mapper.writeValueAsString(mapper.readTree(result.getJsonString())));
    }
}
