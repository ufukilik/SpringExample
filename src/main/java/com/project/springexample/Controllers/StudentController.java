package com.project.springexample.Controllers;

import com.project.springexample.Entities.Student;
import com.project.springexample.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Student> findById(@RequestBody int id) {
        return this.studentRepository.findById(id);
    }

    @PatchMapping("/update")
    public void update(@RequestBody Student student) {
        this.studentRepository.save(student);
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student) {
        this.studentRepository.save(student);
    }

    @PostMapping("/addAll")
    public void addAll(@RequestBody List<Student> student) {
        this.studentRepository.saveAll(student);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Student student) {
        this.studentRepository.delete(student);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(@RequestBody List<Student> student) {
        this.studentRepository.deleteAll(student);
    }
}
