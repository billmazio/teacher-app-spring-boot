package com.example.teacherapp.controller;

import com.example.teacherapp.entity.Teacher;
import com.example.teacherapp.repository.TeacherRepository;
import com.example.teacherapp.service.TeacherServiceImpl;
import com.example.teacherapp.service.UserService;
import com.example.teacherapp.service.TeacherService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    private TeacherRepository teacherRepository;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teacher/new")
    public String showNewForm (Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("pageTitle", "Add New Teacher");
        return "teacherform";
    }



    @PostMapping("/teacher/save")
    public String saveTutorial(Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            teacherService.saveTeacher(teacher);

            redirectAttributes.addFlashAttribute("message", "The Teacher has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/allTeachers";
    }

    @GetMapping("/allTeachers")
    public String getAll(Model model, @Param("lastName") String lastName) {
        try {
            List<Teacher> teacherList = new ArrayList<Teacher>();

            if (lastName != null) {
                teacherService.findBySurname(lastName).forEach(teacherList::add);
            } else {
                teacherService.findAll().forEach(teacherList::add);
                model.addAttribute("lastName", lastName);
            }

            model.addAttribute("teacherList",teacherList);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "teacher";
    }


@GetMapping("/edit/{id}")
public String showFormForUpdate (@PathVariable(value = "id") String teacherId, Model model, Teacher teacher,RedirectAttributes redirectAttributes) {
    try {
        Integer pId = Integer.parseInt(teacherId);
        teacher = teacherService.findTeacherById(pId);
        Teacher teacher1 = teacherService.updateTeacher(teacher);
        model.addAttribute("teacher", teacher);//set form
        model.addAttribute("model", model);
        model.addAttribute("pageTitle", "Edit Teacher (ID: " + teacherId + ")");
        return "teacherform";
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("message", e.getMessage());


    }
    return "teacherFormEdit2Update";
}
@SneakyThrows
@PostMapping(value = "/update/{id}")
public String updateTeacher(@PathVariable("id") String id, Teacher teacher)  {
    Integer pId = Integer.parseInt(id);
    Teacher  currentTeacher = null;
    currentTeacher = teacherService.findTeacherById(pId);
    currentTeacher = teacher;
    currentTeacher.setId(teacher.getId());
    currentTeacher.setFirstName(teacher.getFirstName());
    currentTeacher.setLastName(teacher.getLastName());
    teacherService.updateTeacher(currentTeacher);
    return "redirect:/allTeachers";
}


    @GetMapping("/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            teacherService.deleteTeacherById(id);

            redirectAttributes.addFlashAttribute("message", "The Teacher with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/allTeachers";
    }

}
