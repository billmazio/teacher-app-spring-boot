package com.example.teacherapp.entity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    User user = new User();

    @Test
    void getId() {
        user.setId(1);
        assertEquals(1,user.getId());
    }

    @Test
    void setId() {
        user.setId(1);
        assertEquals(1,user.getId());
    }

    @Test
    void getEmail() {
      user.setEmail("Test");
      assertEquals("Test",user.getEmail());
    }
    @Test
    void setEmail() {
        user.setEmail("Test");
        assertEquals("Test",user.getEmail());
    }

    @Test
    void getPassword() {
        user.setPassword("Test");
        assertEquals("Test",user.getPassword());
    }


    @Test
    void setPassword() {
        user.setPassword("Test");
        assertEquals("Test",user.getPassword());
    }

}
