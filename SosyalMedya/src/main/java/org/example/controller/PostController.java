package org.example.controller;

import org.example.entity.Posts;
import org.example.service.PostService;

import java.util.Scanner;

public class PostController {
    private static PostController postController;
    Scanner src=new Scanner(System.in);
    public static PostController getPostController(){
        if (postController==null){
            return new PostController();
        }else {
            return postController;
        }
    }
    PostService postService=PostService.getPostService();


public void createPost(){
    String postIcerik;
    System.out.println("Post içeriğini giriniz: ");
    postIcerik=src.nextLine();
    postService.createPost(postIcerik);
}

public void yorumYap(){
    postService.YorumYap();
}


    public void postlariGetir(){
        postService.getAll();
    }

}
