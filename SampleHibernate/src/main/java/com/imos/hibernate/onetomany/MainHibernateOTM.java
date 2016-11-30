/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.onetomany;

import com.imos.hibernate.utils.Database;
import com.imos.hibernate.utils.HibernateUtils;
import java.util.List;

/**
 *
 * @author Alok
 */
public class MainHibernateOTM {

    public static void main(String[] args) {
        HibernateUtils hu = HibernateUtils.getInstance();
        hu.setDatabase(Database.SAMPLE_DB);
        try {
            UserDetailOTM user1 = new UserDetailOTM();
            user1.setName("Alok");

            VehicleOTM vehicle1 = new VehicleOTM();
            vehicle1.setName("Car A");
            vehicle1.setOwner(user1);

            user1.getVehicles().add(vehicle1);

            VehicleOTM vehicle2 = new VehicleOTM();
            vehicle2.setName("Car B");
            vehicle2.setOwner(user1);

            user1.getVehicles().add(vehicle2);

            UserDetailOTM user2 = new UserDetailOTM();
            user2.setName("Alok");

            VehicleOTM vehicle3 = new VehicleOTM();
            vehicle3.setName("Car A");
            vehicle3.setOwner(user2);

            user2.getVehicles().add(vehicle3);

            VehicleOTM vehicle4 = new VehicleOTM();
            vehicle4.setName("Car B");
            vehicle4.setOwner(user2);

            user2.getVehicles().add(vehicle4);

            hu.save(user1, user2, vehicle1, vehicle2, vehicle3, vehicle4);
            
            List<UserDetailOTM> list = hu.executeQuery("from UserDetailOTM");
            list.stream()
                    //                    .map(m -> {UserDetailOTO u = (UserDetailOTO)m; return u;})
                    .forEach(u -> {
                        System.out.println(u.getName() + " " + u.getVehicles());
                    });
//                    .forEach(System.out::println);
        } finally {
            hu.closeConnection();
        }
    }
}
