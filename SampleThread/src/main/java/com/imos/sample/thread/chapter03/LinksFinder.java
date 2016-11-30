/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter03;

import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

/**
 *
 * @author Alok
 */
public class LinksFinder {
  public static Set<String> getLinks(String url) {
    try {
      String content = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
      return  Stream.of(content.split("<A href='"))
                    .skip(1)
                    .map(line -> line.split("'")[0])
                    .map(link -> toAbsoluteURL(url, link))
                    .collect(toSet());
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static String toAbsoluteURL(String baseURL, String link) {
    try {
      return link.startsWith("http") ? link : new URL(new URL(baseURL), link).toString();      
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
