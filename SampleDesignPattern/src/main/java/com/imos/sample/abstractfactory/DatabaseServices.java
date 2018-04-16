/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.abstractfactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ameher
 */
public class DatabaseServices {

    public static Map<String, IDatabase> services = new HashMap<>();
}
