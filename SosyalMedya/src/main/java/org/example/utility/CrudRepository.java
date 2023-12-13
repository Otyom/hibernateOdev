package org.example.utility;

import org.example.config.HibernateConfig;
import org.hibernate.Session;



public class CrudRepository<T,ID> implements ICrudRepository<T,ID>{
    DbConnection dbConnection=Singleton.getDbConnection();


    @Override
    public void create(T t) {
        try {
            Session session= HibernateConfig.getSessionFaktory().openSession();
            session.save(t);
            session.close();
        }catch (Exception e){
            System.out.print("HibernateConfigte hata oluştu");
            e.printStackTrace();
        }

    }

    @Override
    public void delete(T t) {
        try {
            Session session=HibernateConfig.getSessionFaktory().openSession();
            session.delete(t);
            session.close();
        }catch (Exception e){
            System.out.print("HibernateConfigte hata oluştu");
            e.printStackTrace();
            dbConnection.rollback();
        }

    }


@Override
    public <T> T getById(Class<T> tClass, ID id) {
        try (Session session = HibernateConfig.getSessionFaktory().openSession()) {
            T t = session.get(tClass, id);
            session.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) tClass;
        }
    }

    @Override
    public void update(T t) {
        try {
            dbConnection.openSession();
            dbConnection.session.update(t);
            dbConnection.closeSession();
        }catch (Exception e){
            dbConnection.rollback();
        }
    }


}
