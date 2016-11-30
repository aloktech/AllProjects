/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.query.oto;

import com.imos.hibernate.utils.Database;
import com.imos.hibernate.utils.HibernateUtils;
import java.util.List;

/**
 *
 * @author Pintu
 */
public class SimpleQueryWithNoNPlusOneProblem {

    public static void main(String[] args) {
        HibernateUtils hu = HibernateUtils.getInstance();
        hu.setDatabase(Database.SAMPLE_DB);
        try {
            System.out.println("JOIN");
            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  join u.vehicle v with v.id =  3");
            System.out.println("INNER JOIN");
            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  inner join u.vehicle v with v.id =  3");
            System.out.println("FULL OUTER JOIN");
//            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  full join u.vehicle v with v.id =  3");
            System.out.println("LEFT JOIN == LEFT OUTER JOIN");
            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  left join u.vehicle v with v.id =  3");
            System.out.println("RIGHT JOIN == RIGHT OUTER JOIN");
            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  right join u.vehicle v with v.id =  3");
//            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u,  VehicleOTO v where v.id =  u.vehicle_fk");
//            typeOfQuery(hu, "select u.name, v.name from UserDetailOTO u  right join u.vehicle v on u.vehicle_fk = v.id");
        } finally {
            hu.closeConnection();
        }
    }

    private static void typeOfQuery(HibernateUtils hu, String query) {
        List list = hu.executeQuery(query);
        for (Object obj : list) {
            Object[] u = (Object[]) obj;
            String[] value = new String[u.length];
            int index = 0;
            for (Object o : u) {
                if (o != null) {
                    value[index] = o.toString();
                    index++;
                }
            }
            System.out.println(String.join(", ", value));
        }
        System.out.println("");
    }
}
