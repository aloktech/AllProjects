/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.onetoone;

import com.imos.hibernate.utils.Database;
import com.imos.hibernate.utils.HibernateUtils;

/**
 *
 * @author Alok
 */
public class MainHibernateOTO {

    public static void main(String[] args) {
        HibernateUtils hu = HibernateUtils.getInstance();
//        hu.setDatabase(Database.CHECK_DB);
//        hu.setDatabase(Database.SKILL_DB);
        hu.setDatabase(Database.SAMPLE_DB);
        try {
            UserDetailOTO user = new UserDetailOTO();
            user.setName("Alok");

            VehicleOTO vehicle = new VehicleOTO();
            vehicle.setName("Car");
            vehicle.setOwner(user);

            user.setVehicle(vehicle);

            UserDetailOTO user1 = new UserDetailOTO();
            user1.setName("Alok1");
            
            VehicleOTO vehicle1 = new VehicleOTO();
            vehicle1.setName("Car1");
            
            hu.save(user, user1, vehicle, vehicle1);

        } finally {
            hu.closeConnection();
        }
    }
}
