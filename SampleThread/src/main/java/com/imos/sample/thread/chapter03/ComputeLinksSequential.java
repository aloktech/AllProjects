/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter03;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alok
 */
public class ComputeLinksSequential implements ComputeLinks {

    private final Set<String> visited = new HashSet<>();

    public void visitSubLinks(String url) {
        visited.add(url);

        LinksFinder.getLinks(url)
                .stream()
                .filter(link -> !visited.contains(link))
                .forEach(this::visitSubLinks);
    }

    @Override
    public long countLinks(String url) {
        visitSubLinks(url);
        return visited.size();
    }
}
