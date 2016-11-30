/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.query.oto;

import com.imos.hibernate.manytomany.UserDetailMTM;
import com.imos.hibernate.onetomany.UserDetailOTM;
import com.imos.hibernate.onetoone.UserDetailOTO;
import com.imos.hibernate.utils.Database;
import com.imos.hibernate.utils.HibernateUtils;
import java.util.List;

/**
 *
 * @author Pintu
 */
public class SimpleQueryWithNPlusOneProblem {

    public static void main(String[] args) {
        HibernateUtils hu = HibernateUtils.getInstance();
        hu.setDatabase(Database.SAMPLE_DB);
        try {

            List<UserDetailOTO> listoto = hu.executeQuery("from UserDetailOTO");
            listoto.stream()
                    //                    .map(m -> {UserDetailOTO u = (UserDetailOTO)m; return u;})
                    //                    .forEach(u -> {System.out.println(u.getName());});
                    .forEach(System.out::println);
            System.out.println("");
            List<UserDetailOTM> listotm = hu.executeQuery("from UserDetailOTM");
            listotm.stream()
                    //                    .map(m -> {UserDetailOTO u = (UserDetailOTO)m; return u;})
                    .forEach(u -> {
                        System.out.println(u.getName() + " " + u.getVehicles());
                    });
//                    .forEach(System.out::println);
            System.out.println("");
            List<UserDetailMTM> listmtm = hu.executeQuery("from UserDetailMTM");
            listmtm.stream()
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
