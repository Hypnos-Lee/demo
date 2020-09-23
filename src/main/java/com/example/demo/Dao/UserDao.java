package com.example.demo.Dao;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String userName);
}
