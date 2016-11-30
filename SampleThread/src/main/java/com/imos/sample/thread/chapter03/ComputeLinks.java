/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter03;

import java.util.Map;

/**
 *
 * @author Alok
 */
public interface ComputeLinks {

    final static String TOPURL = "http://www.agiledeveloper.com/venkat/countlinkssample/index.html";

    static void reportResultAndTime(String startingURL, ComputeLinks computeLinks) {
        try {
            Map<String, Object> response = Timeit.measure(() -> computeLinks.countLinks(startingURL));
            System.out.println("The number of links is: " + response.get("result"));
            System.out.printf("%s Time taken(s): %s\n",
                    computeLinks.getClass().getSimpleName(), response.get("Time"));
        } catch (Exception ex) {
            System.out.println("Error processing: " + ex.getMessage());
        }
    }

    long countLinks(String url);

    static void main(String[] args) {
        ComputeLinks.reportResultAndTime(TOPURL, new ComputeLinksSequential());
        ComputeLinks.reportResultAndTime(TOPURL, new ComputeLinksConcurrent());
    }
}
