package com.example.demo.Sevice;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(UserEntity user){
        return userDao.findByUserName(user.getUserName()) != null;
    }

    public boolean isPswCorrect(UserEntity user){
        return Objects.equals(user.getPassWord(), userDao.findByUserName(user.getUserName()).getPassWord());
    }

    public void save(UserEntity user){
        userDao.save(user);
    }

    public UserEntity getUserByName(String userName){
        return userDao.findByUserName(userName);
    }

}
