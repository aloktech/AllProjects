/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.model.ConnectionType;
import com.imos.sample.model.KioskDetail;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Pintu
 */
public class MainSampleJPA {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SampleJPA");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        KioskDetail kioskDetail = new KioskDetail();
        kioskDetail.setConnectionType(ConnectionType.KIOSK_ACTIVE);
        kioskDetail.setIpAddress("1.2.3.4.5");
        kioskDetail.setKioskId("Aps34");
        em.persist(kioskDetail);
        tran.commit();
        em.clear();
        em.close();
        factory.close();
        System.out.println("done");
    }
}
