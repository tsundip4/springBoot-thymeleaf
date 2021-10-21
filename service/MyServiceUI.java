package com.example.springUI.service;

import com.example.springUI.model.StudentModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyServiceUI {

    List<StudentModel> list = new ArrayList<>();

    public List<StudentModel> getList() {
        return list;
    }

    public MyServiceUI() {
        list.add(new StudentModel(100, "sandeep", "bashyal"));
        list.add(new StudentModel(101, "sandy", "bashyal"));
        list.add(new StudentModel(102, "sagar", "bashyal"));
    }


    public List<StudentModel> getAllStudent() {
        return list;
    }

    public StudentModel getStudentById(int id) {
        return  list.stream().filter(t->t.getId()==id).findFirst().get();
    }

    public void addStudent(StudentModel studentModel){
        list.add(studentModel);
    }

}
