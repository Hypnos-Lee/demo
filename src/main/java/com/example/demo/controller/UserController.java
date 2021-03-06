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


    @PostMapping("/login")
    public Result<UserEntity> login(@PathParam("userName") String userName, @PathParam("passWord") String passWord){
//    public Result login(@RequestBody UserEntity requestUser){
        UserEntity requestUser = new UserEntity();
        requestUser.setUserName(userName);
        requestUser.setPassWord(passWord);

        Result<UserEntity> result = new Result<>(200,"登录成功");
        if(userName==null || passWord==null){
            result.setStatus(201);
            result.setMsg("账号密码不能为空");
        }
        else if(userName.length()>20 || userName.length()<3){
            result.setStatus(201);
            result.setMsg("用户名长度应在3~20位之间");
        }
        else if(passWord.length()>20 || passWord.length()<6){
            result.setStatus(201);
            result.setMsg("密码长度应在6~20位之间");
        }
        else if(!userService.isExist(requestUser)){
            result.setStatus(201);
            result.setMsg("用户不存在");
        }
        else if(!userService.isPswCorrect(requestUser)){
            result.setStatus(201);
            result.setMsg("账号或密码错误");
        }
        else{
            result.setData(userService.getUserByName(userName));
        }
        return result;
    }

    @PostMapping("/register")
    public Result<String > register(@PathParam("userName") String userName, @PathParam("passWord") String passWord){
        UserEntity requestUser = new UserEntity();
        requestUser.setUserName(userName);
        requestUser.setPassWord(passWord);

        Result<String > result = new Result<String >(200,"注册成功");

        if(userName==null || passWord==null){
            result.setStatus(201);
            result.setMsg("账号密码不能为空");
        }
        else if(userName.length()>20 || userName.length()<3){
            result.setStatus(201);
            result.setMsg("用户名长度应在3~20位之间");
        }
        else if(passWord.length()>20 || passWord.length()<6){
            result.setStatus(201);
            result.setMsg("密码长度应在6~20位之间");
        }
        else if(userService.isExist(requestUser)){
            result.setStatus(201);
            result.setMsg("用户已存在");
        }
        else{
            userService.save(requestUser);
        }
        return result;
    }

}
