package org.example.service;


import org.example.controller.ComentController;
import org.example.entity.Posts;

import org.example.repository.PostRepository;
import org.example.utility.Singleton;


import java.util.Scanner;


public class PostService {
    Scanner src=new Scanner(System.in);
    private static PostService postService;
    public static PostService getPostService(){
        if (postService==null){
            return new PostService();
        }else {
            return postService;
        }
    }


    PostRepository postRepository=PostRepository.getPostRepository();
    ComentController comentController=Singleton.getComentController();
    public void createPost(String post){
        Posts posts=new Posts(post);
        postRepository.create(posts);
    }

    public Posts findByPost(int id){
        Posts posts= postRepository.getById(Posts.class,id);
        if (postRepository.getById(Posts.class,id)==null){
            return posts;
        }
        return posts;
    }

    public void YorumYap() {
        System.out.println("Yorum yapılacak postun id'sini girin: ");
        int id = src.nextInt();
        if (findByPost(id) == null){
            System.out.println("Post bulunamadı...");
        }else {
            comentController.createYorum();
        }
    }
    public void getAll(){
        for (Posts posts: postRepository.getAll()){
            System.out.println(posts.toString()+" ");
        }
    }

}
