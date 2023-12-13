package org.example.service;

import org.example.entity.Comment;
import org.example.repository.ComentRepository;
import org.example.utility.Singleton;

import java.util.Scanner;

public class ComentService {
    Scanner src=new Scanner(System.in);
    ComentRepository comentRepository= Singleton.getcomentRepository();

    public void yeniComent(){

        System.out.println("Yorum girin: ");
        String yorum=src.nextLine();
        Comment comment=new Comment(yorum);
        comentRepository.create(comment);
    }
}
