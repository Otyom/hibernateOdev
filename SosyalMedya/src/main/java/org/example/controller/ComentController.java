package org.example.controller;

import org.example.service.ComentService;
import org.example.utility.Singleton;

public class ComentController {
    ComentService comentService= Singleton.getComentService();
    public void createYorum(){
        comentService.yeniComent();
    }
}
