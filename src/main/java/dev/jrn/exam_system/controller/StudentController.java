package dev.jrn.exam_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.jrn.exam_system.entity.Student;
import dev.jrn.exam_system.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/all")
    public List<Student> fetchAllStudents() { return studentService.getAllStudents(); }

    @GetMapping(path = "/id")
    public Optional<Student> getStudentById(@RequestParam Integer student_id) {
        return studentService.getStudentById(student_id);
    }

    @DeleteMapping(path = "{student_id}")
    public void deleteStudentById(@PathVariable("student_id") Integer student_id) {
        studentService.deleteStudentById(student_id);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{student_id}")
    public void updateStudent(@PathVariable("student_id") Integer student_id, @RequestParam(required = false) String first_name, @RequestParam(required = false) String last_name) {
        studentService.updateStudent(student_id, first_name, last_name);
    }
    
}
