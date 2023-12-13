package org.example;

import org.example.controller.ComentController;
import org.example.controller.PostController;
import org.example.controller.UsersController;
import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.example.service.UsersService;
import org.example.utility.Singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersController usersController= Singleton.getUsersController();
        PostController postController=PostController.getPostController();
        ComentController comentController=Singleton.getComentController();

        Scanner src=new Scanner(System.in);
        System.out.println("\t Otyom's Uygulamasına Hoşgeldiniz...");

        boolean cikis=true;
        int islem;



        while(cikis==true) {
            System.out.println("Bir işlem seçiniz:");
            anaIslemleri_bastir();
            islem = src.nextInt();
            switch(islem) {
                case 0:
                    break;




                case 1:
                    if (usersController.girisKontrol()==true) {
                        boolean altcikis = true;
                        while (altcikis==true) {
                            System.out.println("Bir işlem seçiniz: ");
                            islemleri_bastir();
                            int secim = src.nextInt();
                            switch (secim) {
                                case 0:
                                    break;
                                case 1:
                                    postController.postlariGetir();
                                    break;
                                case 2:
                                    postController.createPost();
                                    break;
                                case 3:
                                    postController.yorumYap();  //yorum kısmı join yarım kaldı yapılacak......
                                    break;
                                case 4:
                                    usersController.update();
                                    break;
                                case 5:
                                    altcikis = false;
                                    System.out.println("Uygulamadan çılkıldı");
                                    break;
                            } //swich-case
                        }//altDöngü

                    }else {
                        System.out.println("kullanıcı adı veya şifre yanlış");
                    }
                    break;





                case 2:
                    usersController.createUser();
                    break;
                case 3:
                    cikis = false;
                    System.out.println("Uygulamadan çıkıldı...");
                    break;
                case 4:
                    usersController.deleteUser();
            }


        }
    }


    public static void anaIslemleri_bastir() {
        System.out.println("\t 0-İşlemleri Görüntüle");
        System.out.println("\t 1-Giriş");
        System.out.println("\t 2-Kayıt ol");
        System.out.println("\t 3-Çıkış");
        System.out.println("\t 4-Hesabımı sil");
    }
    public static void islemleri_bastir() {
        System.out.println("\t 0-İşlemleri Görüntüle");
        System.out.println("\t 1-Postları Görüntüle");
        System.out.println("\t 2-Post Ekle");
        System.out.println("\t 3-Post Yorum Yap");
        System.out.println("\t 4-Profilimi güncelle");
        System.out.println("\t 5-Uygulamadan Çık");
    }
}