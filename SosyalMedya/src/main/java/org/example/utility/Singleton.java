package org.example.utility;

import org.example.config.HibernateConfig;
import org.example.controller.ComentController;
import org.example.controller.UsersController;
import org.example.repository.ComentRepository;
import org.example.repository.UsersRepository;
import org.example.service.ComentService;
import org.example.service.UsersService;

public class Singleton {

    private static DbConnection dbConnection;
    public static DbConnection getDbConnection(){
        if (dbConnection==null){
            return new DbConnection();
        }else {
            return dbConnection;
        }
    }



    private static UsersRepository usersRepository;
    public static UsersRepository getUsersRepository(){
        if (usersRepository==null){
            return new UsersRepository(HibernateConfig.getSessionFaktory());
        }else {
            return usersRepository;
        }
    }



    private static UsersController usersController;
    public static UsersController getUsersController(){
        if (usersRepository==null){
            return new UsersController();
        }else {
            return usersController;
        }
    }


    private static UsersService usersService;
    public static UsersService getUsersService(){
        if (usersService==null){
            return new UsersService();
        }else {
            return usersService;
        }
    }


    private static ComentRepository comentRepository;
    public static ComentRepository getcomentRepository(){
        if (comentRepository==null){
            return new ComentRepository();
        }else {
            return comentRepository;
        }
    }


    private static ComentService comentService;
    public static ComentService getComentService(){
        if (comentRepository==null){
            return new ComentService();
        }else {
            return comentService;
        }
    }


    private static ComentController comentController;
    public static ComentController getComentController(){
        if (comentController==null){
            return new ComentController();
        }else {
            return comentController;
        }
    }


}
