package com.example.springUI.controllerUI;

import com.example.springUI.model.StudentModel;
import com.example.springUI.service.MyServiceUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyControllerUI {

    @Autowired
    private MyServiceUI myServiceUI;

    @GetMapping("/students")
    public String StudentListUI(Model model){
        model.addAttribute("studentInfo", myServiceUI.getAllStudent());
        return "index";
    }

    @GetMapping("/login")
    public String loginStudent(){
        return "login";
    }

    @GetMapping("/loginById")
    public String getStudentById(@RequestParam(value = "id", required = false) int id,  Model model){
        model.addAttribute("studentById", myServiceUI.getStudentById(id));
        System.out.println(id);
        return "studentbyid";
    }

    @PostMapping("/addStudents")
    public void addStudents(@ModelAttribute StudentModel stModel){
        myServiceUI.addStudent(new StudentModel(stModel.getId(),stModel.getfName(),stModel.getlName()));
    }

    @GetMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }

    @PostMapping("/postData")
    public void postData(){
      myServiceUI.addStudent(new StudentModel(104, "sara", "khan"));
    }


}
