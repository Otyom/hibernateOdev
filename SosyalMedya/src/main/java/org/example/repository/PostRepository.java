package org.example.repository;

import org.example.entity.Posts;
import org.example.utility.CrudRepository;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

import java.util.ArrayList;
import java.util.List;

public class PostRepository extends CrudRepository<Posts, Integer> {
    private static PostRepository postRepository;
    public static PostRepository getPostRepository(){
        if (postRepository==null){
            return new PostRepository();
        }else {
            return postRepository;
        }
    }


    public List<Posts> getAll() {
        DbConnection dbConnection = Singleton.getDbConnection();

        List<Posts> posts = new ArrayList<>();
        try {
            dbConnection.openSession();
            posts =
                    dbConnection.session.createNativeQuery("select * from posts", Posts.class).getResultList();
            dbConnection.closeSession();
            return posts;
        } catch (Exception e) {
            dbConnection.rollback();
            return posts;
        }
    }


}
