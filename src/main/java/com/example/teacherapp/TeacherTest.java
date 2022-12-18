package com.example.teacherapp.entity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class TeacherTest {
    Teacher teacher = new Teacher();

    @Test
    void getId() {
        teacher.setId(1);
        assertEquals(1,teacher.getId());
    }
    @Test
    void setId() {
        teacher.setId(1);
        assertEquals(1,teacher.getId());
    }
    @Test
    void getFirstName() {
        teacher.setFirstName("Test");
        assertEquals("Test", teacher.getFirstName());
    }

    @Test
    void setFirstName() {
       teacher.setFirstName("Test");
        assertEquals("Test", teacher.getFirstName());
    }

    @Test
    void getLastName() {
        teacher.setLastName("Test");
        assertEquals("Test", teacher.getLastName());
    }

    @Test
    void setLastName() {
        teacher.setLastName("Test");
        assertEquals("Test", teacher.getLastName());
    }
}