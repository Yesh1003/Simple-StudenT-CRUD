package com.StudentRegistration.Application.Controller;

import com.StudentRegistration.Application.Entity.Student;
import com.StudentRegistration.Application.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public Student saveData(@RequestBody Student student){
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @GetMapping("/getid/{id}")
    public Optional<Student> findById(@PathVariable Integer id){
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Successfully Deleted";
    }
}
