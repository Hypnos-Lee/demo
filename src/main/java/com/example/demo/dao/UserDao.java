package com.example.demo.dao;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String userName);
}
