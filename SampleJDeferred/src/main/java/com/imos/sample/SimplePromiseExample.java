/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 */
public class SimplePromiseExample {

    public static void main(String[] args) {
        System.out.println("## Example 1");
        Multiplier m = new Multiplier(6);
        m.promise().progress(System.out::println).done((res) -> System.out.println("the result is: " + res));
        m.multiplyNTimes(5);

        System.out.println("## Example 2");
        WebCrawler crawler = new WebCrawler();
        crawler.promise().progress((i) -> System.out.println("Progress: " + i + "%")).done((keywords) -> {
            System.out.println("Done, " + keywords.size() + " keywords found: ");
            keywords.forEach(System.out::println);
        });
        crawler.crawl("http://www.hascode.com/");

    }
}
