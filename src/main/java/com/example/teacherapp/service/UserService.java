package com.example.teacherapp.service;

import com.example.teacherapp.entity.User;


public interface UserService {
    User login(String email, String password);

    User save(User user);
}
