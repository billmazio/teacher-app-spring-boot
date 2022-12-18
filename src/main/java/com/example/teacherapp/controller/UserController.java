package com.example.teacherapp.controller;

import com.example.teacherapp.entity.User;
import com.example.teacherapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
@Autowired
private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("userLogin");
        mav.addObject("userInsert", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userInsert") User user) {
        User oauthTeacher = userService.login(user.getEmail(), user.getPassword());
        if (oauthTeacher != null) {
            return "redirect:/allTeachers";
        }
        else {
            return "registration";
        }
    }


    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("userInsert", new User());
        return mav;
    }
    @PostMapping("/sign-up")
    public String register(User user){
        User newUser = userService.save(user);
        return "redirect:/login";
    }


}
