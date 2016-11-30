/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Pintu
 */
public class DistributedMap {

    public static void main(String[] args) {
        HazelcastInstance h = HazelcastClient.newHazelcastClient();
        ConcurrentMap<String, String> map = h.getMap("my-distributed-map");
        map.put("key", "value");
        map.get("key");

        //Concurrent Map methods
        map.putIfAbsent("somekey", "somevalue");
        map.replace("key", "value", "newvalue");
        HazelcastInstance hzInstance = HazelcastClient.newHazelcastClient();
        System.out.println(hzInstance.getLifecycleService().isRunning());
    }
}
