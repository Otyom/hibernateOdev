package org.example.utility;

import org.example.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DbConnection {
    public Transaction transaction=null;
    public Session session=null;

    public void openSession(){
        session= HibernateConfig.getSessionFaktory().openSession();
        transaction=session.beginTransaction();
    }
    public void closeSession(){
        transaction.commit(); //comit-gönderme
        session.close();
    }
    public void rollback(){
        transaction.rollback();
        session.close();
    }

}
