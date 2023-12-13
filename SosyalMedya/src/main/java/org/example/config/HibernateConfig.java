package org.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static HibernateConfig hibernateConfig=null;
    private static SessionFactory sessionFactory=null;
    public static SessionFactory getSessionFaktory(){
        if (sessionFactory==null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
                return sessionFactory;
            } catch (Exception e) {
                System.out.println("Configte hata oluştu");
                e.printStackTrace();
                return sessionFactory;
            }
        }else {
            return sessionFactory;
        }

    }


}
