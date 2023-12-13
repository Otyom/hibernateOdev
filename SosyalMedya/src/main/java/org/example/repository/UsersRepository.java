package org.example.repository;

import org.example.entity.Users;
import org.example.utility.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UsersRepository  extends CrudRepository<Users,Integer> {



    private final SessionFactory sessionFactory;
    public UsersRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Users findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createQuery("from Users where username = :username",Users.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
