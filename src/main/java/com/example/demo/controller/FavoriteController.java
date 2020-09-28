package com.example.demo.controller;

import com.example.demo.sevice.FavoriteService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

//    @PostMapping("/changefavorite")
//    public Result<String>
}
