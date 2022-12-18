package com.example.teacherapp.service;

import com.example.teacherapp.entity.User;
import com.example.teacherapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;



    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User login(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
