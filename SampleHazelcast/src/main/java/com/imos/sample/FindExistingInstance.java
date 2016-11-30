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
import com.hazelcast.core.HazelcastInstanceAware;
import com.hazelcast.core.IExecutorService;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author Pintu
 */
public class FindExistingInstance {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Config config = new Config();
        HazelcastInstance h = HazelcastClient.newHazelcastClient();
        System.out.println("B : "+h);
        IExecutorService ex = h.getExecutorService("my-distributed-executor");
        Future<HazelcastInstance> future = ex.submit(new Find());
        System.out.println("A : "+future.get());
    }
}
class Find implements HazelcastInstanceAware, Callable<HazelcastInstance>, Serializable {

    private HazelcastInstance hazelcastInstance;
    
    @Override
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public HazelcastInstance call() throws Exception {
        return hazelcastInstance;
    }
    
}
