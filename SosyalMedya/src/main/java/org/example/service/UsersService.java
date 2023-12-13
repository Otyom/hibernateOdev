package org.example.service;

import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.example.utility.Singleton;

import java.util.Scanner;


public class UsersService {
    Scanner src=new Scanner(System.in);
    Scanner scn=new Scanner(System.in);
    UsersRepository usersRepository= Singleton.getUsersRepository();


    String userName;
    String password;


    public void createUser(String ad,String soyAd,String userName,String password){
        Users users=Users.builder().ad(ad).soyad(soyAd).username(userName).password(password).build();
        usersRepository.create(users);
    }

    public void delete(int id){
        Users users=getUserId(id);
        if (users==null){
            System.out.println("Kullanıcı yok");
        }
        usersRepository.delete(users);
        System.out.println("Silindi");
    }

    public Users getUserId(int id){
        Users users;
        users=usersRepository.getById(Users.class,id);
        if (users==null){
            System.err.println("id bulunamadı");
        }
        return users;

    }

    public void update(int id,String userName,String password){
            Users users=getUserId(id);
        System.out.println("1_userName\n2_password");
        int secim=scn.nextInt();
            switch (secim) {
                case 1:
                    System.out.println("Değiştirilecek kullanıcı adını girin: ");
                    userName= src.nextLine();
                    users.setUsername(userName);
                    break;
                case 2:
                    System.out.println("Değiştirilecek kullanıcı adını girin: ");
                   password= scn.nextLine();
                    users.setPassword(password);
                    break;
                default:
                    System.out.println("Yanlış seçim yaptınız....");
                    break;
                }
                usersRepository.update(users);
    }

    public boolean findUser() {
        System.out.println("Kullanıcı adınızı girin");
        userName = src.nextLine();
        System.out.println("Şifrenizi girin");
        password = src.nextLine();
        Users users=usersRepository.findByUsername(userName);
        if (users != null && users.getPassword().equals(password)) {
            System.out.println(users);
            return true;
        }else {
            return false;
        }
    }














}
