package com.example.teacherapp.repository;

import com.example.teacherapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "select * from TEACHERS t where l_name like %:lastName% ", nativeQuery = true)
  // @Query( value = "SELECT * FROM TEACHERS t  WHERE l_name  like %:lastName% ", nativeQuery = true )
    List<Teacher>  findBySurname(@Param("lastName") String lastName);
    List<Teacher> findAll();
    Teacher findTeacherById(int id);



}
