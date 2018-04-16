/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.alibaba.fastjson.JSON;
import java.util.Date;

/**
 *
 * @author Pintu
 */
public class SampleFastJSON {

    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        guestUser.setDateOfBirth(new Date());

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
        
        group = JSON.parseObject(jsonString, Group.class);
        
        System.out.println(group);
        
        jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
    }
}
