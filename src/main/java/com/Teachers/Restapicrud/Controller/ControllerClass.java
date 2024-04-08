package com.Teachers.Restapicrud.Controller;


import com.Teachers.Restapicrud.Entity.Teachers;
import com.Teachers.Restapicrud.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


import java.util.List;
@Controller
@RequestMapping("/teachers")
public class ControllerClass {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

    private ServiceInterface serviceInterface;
    @Autowired
    public ControllerClass(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }
    @GetMapping("/t")
    public String getTeachers(Model model) {
        List<Teachers> teachers = serviceInterface.findTeachers();
        model.addAttribute("teachers", teachers);
        return   "teacher";

    }

    @GetMapping("/t/add")
    public String addTeachers(Model model) {
        model.addAttribute("teachers", new Teachers());
        return "add-teacher";
    }

    @GetMapping("/t/update/{id}")
    public String updateTeachers(@PathVariable int id, Model model) {
        model.addAttribute("teachers", serviceInterface.findTeacherById(id));
        return "update-teacher";
    }

    @GetMapping("/t/{id}")
    public Teachers getTeacherById(@PathVariable int id) {
        return serviceInterface.findTeacherById(id);
    }


    @PostMapping(value = "/t/add", consumes = "application/x-www-form-urlencoded")
    public String addTeachers(@ModelAttribute Teachers teachers, Model model) {
        teachers.setId(0);
        serviceInterface.addTeacher(teachers);

        List<Teachers> newTeachers = serviceInterface.findTeachers();
        model.addAttribute("teachers", newTeachers);
        return "redirect:/teachers/t";
    }

    @PutMapping(value = "/t/update", consumes = "application/x-www-form-urlencoded")
    public String updateTeachers(@ModelAttribute Teachers teachers, Model model) {
        Teachers oldTeacher = serviceInterface.findTeacherById(teachers.getId());

        serviceInterface.updateTeacher(teachers);

        List<Teachers> newTeachers = serviceInterface.findTeachers();
        model.addAttribute("teachers", newTeachers);
        return "redirect:/teachers/t";
    }

    @PostMapping("/t/delete/{id}")
    public String deleteTeachers(@PathVariable int id, Model model) {
        serviceInterface.deleteTeacher(id);
        List<Teachers> teachers = serviceInterface.findTeachers();
        model.addAttribute("teachers", teachers);
        return "redirect:/teachers/t";
    }


}
