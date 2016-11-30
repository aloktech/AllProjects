/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate;

import com.imos.hibernate.dto.PersonDetails;
import com.imos.hibernate.dto.Vehicle;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alok
 */
public class HibernateQueryTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            System.out.println("\nSelect \n");
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

//                Query query = session.createQuery("from Vehicle where vehicleType = 0");
                Query query;
                query = session.createQuery("from PersonDetails");
                List<PersonDetails> list = query.list();
                list.stream().forEach((pd) -> {
                    System.out.println("Object : "+pd);
                    System.out.println("Name : "+pd.getUserName());
                    System.out.println("Vehicle : "+pd.getVehicles());
                    System.out.println("CC : "+pd.getCommunityCenters());
                    System.out.println("Company : "+pd.getCompany());
                    System.out.println("Address : "+pd.getAddresses());
                });
                
                
//                query = session.createQuery("from Vehicle where vehicleType= :value");
                query = session.getNamedQuery("Vehicle.getByVehicleType");
//                query.setInteger(0, 0);
                query.setInteger("vehicleType", Integer.parseInt("0"));
                List<Vehicle> vlist = query.list();
                System.out.println(vlist);
            } catch (Exception e) {
                System.out.println(e.getCause().toString() + " : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getCause().toString() + " : " + e.getMessage());
        }
    }
}
