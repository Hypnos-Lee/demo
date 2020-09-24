package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.sevice.UserService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * 用户相关的函数，如：
 * 1.登录
 * 2.注册
 * 3.修改密码
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("login")
    public Result login(@PathParam("userName") String userName,@PathParam("passWord") String passWord){
//    public Result login(@RequestBody UserEntity requestUser){
        UserEntity requestUser = new UserEntity();
        requestUser.setUserName(userName);
        requestUser.setPassWord(passWord);

        Result result = new Result(200,"登录成功");
        if(!userService.isExist(requestUser)){
            result.setStatusAndMsg(201,"用户不存在");
        }
        else if(!userService.isPswCorrect(requestUser)){
            result.setStatusAndMsg(201,"账号或密码不正确");
        }
        return result;
    }

    @PostMapping("/register")
    public Result register(@PathParam("userName") String userName,@PathParam("passWord") String passWord){
        UserEntity requestUser = new UserEntity();
        requestUser.setUserName(userName);
        requestUser.setPassWord(passWord);

        Result result = new Result(200,"注册成功");
        if(userService.isExist(requestUser)){
            result.setStatusAndMsg(201,"用户已存在");
        }
        else{
            userService.save(requestUser);
        }
        return result;
    }

    @PostMapping("/getmsg")
    public UserEntity getUserMsgByName(@PathParam("userName")String userName){
        return userService.getUserByName(userName);
    }
}
