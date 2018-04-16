/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Pintu
 */
@Data
public class Group {

    private Long id;
    private String name;
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
