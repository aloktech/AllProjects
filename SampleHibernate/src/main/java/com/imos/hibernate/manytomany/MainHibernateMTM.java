/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.manytomany;

import com.imos.hibernate.utils.Database;
import com.imos.hibernate.utils.HibernateUtils;
import java.util.List;

/**
 *
 * @author Alok
 */
public class MainHibernateMTM {

    public static void main(String[] args) {
        HibernateUtils hu = HibernateUtils.getInstance();
        hu.setDatabase(Database.SAMPLE_DB);
        try {
            UserDetailMTM user1 = new UserDetailMTM();
            user1.setName("Alok");

            VehicleMTM vehicle1 = new VehicleMTM();
            vehicle1.setName("Car A");
            vehicle1.getOwners().add(user1);

            user1.getVehicles().add(vehicle1);

            VehicleMTM vehicle2 = new VehicleMTM();
            vehicle2.setName("Car B");
            vehicle2.getOwners().add(user1);

            user1.getVehicles().add(vehicle2);

            UserDetailMTM user2 = new UserDetailMTM();
            user2.setName("Alok");

            VehicleMTM vehicle3 = new VehicleMTM();
            vehicle3.setName("Car A");
            vehicle3.getOwners().add(user2);

            user2.getVehicles().add(vehicle3);

            VehicleMTM vehicle4 = new VehicleMTM();
            vehicle4.setName("Car B");
            vehicle4.getOwners().add(user2);

            user2.getVehicles().add(vehicle4);

            hu.save(user1, user2, vehicle1, vehicle2, vehicle3, vehicle4);
            
            List<UserDetailMTM> list = hu.executeQuery("from UserDetailMTM");
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
