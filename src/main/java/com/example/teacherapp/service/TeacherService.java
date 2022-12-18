package com.example.teacherapp.service;

import com.example.teacherapp.entity.Teacher;


import java.util.List;

public interface TeacherService {




    //create
    Teacher saveTeacher(Teacher teacher);

    //read
    List<Teacher> findAll();

    List <Teacher> findBySurname(String lastName);

    Teacher findTeacherById(int teacherId);


    //update
    Teacher updateTeacher(Teacher teacher);

    //delete
    void deleteTeacherById(int id);










}