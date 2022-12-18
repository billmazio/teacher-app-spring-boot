package com.example.teacherapp.service;

import com.example.teacherapp.entity.Teacher;
import com.example.teacherapp.repository.UserRepo;
import com.example.teacherapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository, UserRepo userRepo) {
        this.teacherRepository = teacherRepository;

    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teacherList=(List<Teacher>) teacherRepository.findAll();
      return teacherList;
    }


    @Override
    public Teacher findTeacherById(int id)  {
       return teacherRepository.findTeacherById(id);


    }

    @Override
    public List<Teacher> findBySurname(String lastName) {

        return teacherRepository.findBySurname(lastName);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }


}
