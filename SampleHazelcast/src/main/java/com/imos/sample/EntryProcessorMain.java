/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.AbstractEntryProcessor;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Pintu
 */
public class EntryProcessorMain {

    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IMap<String, Integer> map = hz.getMap("map");
        map.put("key", 0);
        map.executeOnKey("key", new IncEntryProcessor());
        System.out.println("new value:" + map.get("key"));
    }

    public static class IncEntryProcessor extends AbstractEntryProcessor<String, Integer> implements Serializable {

        @Override
        public Object process(Map.Entry<String, Integer> entry) {
            int oldValue = entry.getValue();
            int newValue = oldValue + 1;
            entry.setValue(newValue);
            return null;
        }
    }
}
