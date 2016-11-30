/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.ArrayList;
import java.util.List;
import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

/**
 *
 * @author Pintu
 */
public class WebCrawler { // ugly, stateful, demonstration only ;)

    private final Deferred<List<String>, String, Integer> deferred = new DeferredObject<>();
    private final List<String> keywordsFound = new ArrayList<>();

    public void crawl(String url) {
        initializeCrawler(); // fake
        deferred.notify(10);
        fetchSiteContent(url);// fake
        deferred.notify(20);
        filterDuplicateKeywords();// fake
        deferred.notify(80);
        storeKeywords();// fake
        deferred.resolve(keywordsFound);
    }

    public Promise<List<String>, String, Integer> promise() {
        return deferred.promise();
    }

    private void storeKeywords() {
        System.out.println("storing keywords");
        keywordsFound.add("foo");
        keywordsFound.add("bar");
        keywordsFound.add("baz");
    }

    private void filterDuplicateKeywords() {
        System.out.println("filtering duplicate keywords");
    }

    private void fetchSiteContent(String url) {
        System.out.println("fetching site content for url: " + url);
    }

    private void initializeCrawler() {
        System.out.println("initializing crawler");
    }
}
