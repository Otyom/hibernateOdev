package org.example.controller;

import org.example.entity.Users;
import org.example.service.UsersService;
import org.example.utility.Singleton;

import java.util.Scanner;

public class UsersController {
    Scanner src=new Scanner(System.in);
UsersService usersService= Singleton.getUsersService();


    public void createUser(){
        String ad,soyAd,userName,password;
            Scanner scn=new Scanner(System.in);
            //Kullanıcı oluşturma
            System.out.println("Adınızı girin: ");
            ad=scn.nextLine();
            System.out.println("Soyadınızı girin: ");
            soyAd=scn.nextLine();
            System.out.println("Kullanıcı adınızı girin: ");
            userName=scn.nextLine();
            System.out.println("Şifrenizi girin: ");
            password=scn.nextLine();
        usersService.createUser(ad,soyAd,userName,password);
    }


    public boolean girisKontrol(){
        if (usersService.findUser()==true){
            return true;
        }else {
            return false;
        }
    }

    public Users getById(int id){
        Users users=usersService.getUserId(id);
        return users;
    }

    public void deleteUser(){
        System.out.println("Silinecek id'yi girin");
        int id=src.nextInt();
        usersService.delete(id);
    }


    public void update(){
        int id;
        String userName=null, password=null;
        System.out.println("Güncellenecek id'yi girin: ");
        id=src.nextInt();
        if (usersService.getUserId(id).getId()==0) {
            usersService.update(id,userName,password);
        }else {
            System.out.println("Kullanıcı bulunamadı");
        }
    }

}
