/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate;

import com.imos.hibernate.dto.Address;
import com.imos.hibernate.dto.AddressType;
import com.imos.hibernate.dto.BaseObject;
import com.imos.hibernate.dto.CommunityCenter;
import com.imos.hibernate.dto.Company;
import com.imos.hibernate.dto.PersonDetails;
import com.imos.hibernate.dto.Vehicle;
import com.imos.hibernate.dto.VehicleType;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alok
 */
public class HibernateTest {

    public static void main(String[] args) {

        PersonDetails pd = new PersonDetails();
//        ud.setUserId(2);
        pd.setUserName("Alok");
        pd.setCreatedDate(new Date());
        pd.setUpdatedTime(new Date());
        pd.setDescription("Sample");

        Address address = new Address();
        address.setAddressType(AddressType.RESIDENT);
        pd.getAddresses().add(address);

        address = new Address();
        address.setAddressType(AddressType.OFFICE);
        pd.getAddresses().add(address);
//        
        address = new Address();
        address.setAddressType(AddressType.PERMANENT);
        pd.getAddresses().add(address);

        System.out.println(pd);

        Company company = new Company();
        company.setName("Invicara");

        pd.setCompany(company);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType(VehicleType.TWO_WHEELER);
        vehicle1.setOwner(pd);
        pd.getVehicles().add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType(VehicleType.FOUR_WHEELER);
        vehicle2.setOwner(pd);
        pd.getVehicles().add(vehicle2);

        CommunityCenter cc = new CommunityCenter();
        cc.setEventName("Marriage");
        cc.getAttendees().add(pd);

        pd.getCommunityCenters().add(cc);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                save(session, pd);
                save(session, company);
                save(session, vehicle1);
                save(session, vehicle2);
                save(session, cc);
                session.getTransaction().commit();
                session.flush();
            } catch (Exception e) {
                System.out.println(e.getCause().toString() + " : " + e.getMessage());
                e.printStackTrace();
            }
            
//            System.out.println("\nSelect \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                id = 126;
//                pd = session.get(PersonDetails.class, id);
//                System.out.println(pd.getId());
//                System.out.println(pd);
//                System.out.println(pd.getAddresses().size());
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nUpdated \n");
//            try (Session session = sessionFactory.openSession()) {
//                update(session, pd);
//                System.out.println(pd.getId());
//                System.out.println(pd);
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nSelect \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                id = pd.getId();
//                pd = session.get(PersonDetails.class, id);
//                System.out.println(pd.getId());
//                System.out.println(pd);
//                System.out.println(pd.getAddresses().size());
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nPersist \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                pd.setUpdatedTime(new Date());
//                session.persist(pd);
//                session.getTransaction().commit();
//                session.flush();
//                System.out.println(pd.getId());
//                System.out.println(pd);
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nSelect \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                id = pd.getId();
//                pd = session.get(PersonDetails.class, id);
//                System.out.println(pd.getId());
//                System.out.println(pd);
//                System.out.println(pd.getAddresses().size());
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nDeleted \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                session.delete(pd);
//                session.getTransaction().commit();
//                System.out.println(pd.getId());
//                System.out.println(pd);
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            System.out.println("\nMerge \n");
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                pd = (PersonDetails) session.merge(pd);
//                id = pd.getId();
//                System.out.println(pd.getId());
////                session.save(pd);
//                session.getTransaction().commit();
//                pd = session.get(PersonDetails.class, id);
//                System.out.println(pd.getId());
//                System.out.println(pd);
//                System.out.println(pd.getAddresses().size());
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
//
//            try (Session session = sessionFactory.openSession()) {
//                saveAndUpdate(session, ud);
//                System.out.println(ud);
//            } catch (Exception e) {
//                System.out.println(e.getCause().toString() + " : " + e.getMessage());
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void saveAndUpdate(final Session session, PersonDetails ud) {
        session.beginTransaction();
        ud.setUpdatedTime(new Date());
        session.saveOrUpdate(ud);
        session.getTransaction().commit();
    }

    private static void update(final Session session, PersonDetails ud) {
        session.beginTransaction();
        ud.setUpdatedTime(new Date());
        session.merge(ud);
        session.getTransaction().commit();
    }

    private static <T extends BaseObject> void save(final Session session, T object) {
        session.beginTransaction();
        object.setCreatedDate(new Date());
        session.save(object);
    }
}
