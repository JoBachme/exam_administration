package dev.jrn.exam_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.jrn.exam_system.entity.StudentTest;
import dev.jrn.exam_system.entity.StudentTestId;
import dev.jrn.exam_system.service.StudentTestService;

@RestController
@RequestMapping(path = "api/v1/st_combination")
public class StudentTestController {
    
    @Autowired
    private StudentTestService studentTestService;

    @GetMapping(path = "/all")
    public List<StudentTest> fetchAllStudentTestCombination() {
        List<StudentTest> list = new ArrayList<>();
        for (StudentTest student : studentTestService.getAllStudentTestCombinations()) {
            list.add(student);
        }
        return list;
    }

    @GetMapping(path = "/id")
    public StudentTest fatchOneByStudentId(@RequestParam(required = true) Integer s_id, @RequestParam(required = true) Integer t_id) {
        return studentTestService.getStudentTestCombinationById(new StudentTestId(s_id, t_id));
    }

    @GetMapping(path = "/tests")
    public List<Object[]> fatchOneByTestId(@RequestParam(required = true) Integer s_id) {
        return studentTestService.findAllByStudent_id(s_id);
    }

    @GetMapping(path = "/students")
    public List<Object[]> fatchOneStudentTestCombination(@RequestParam(required = true) Integer t_id) {
        return studentTestService.findAllByTest_id(t_id);
    }
    
    @GetMapping(path = "/hasPassed")
    public Boolean hasPassed(@RequestParam Integer student_id, @RequestParam Integer test_id) {
        return studentTestService.hasPassed(student_id, test_id);
    }

    @PutMapping(path = "/addTry")
    public void addTries(@RequestParam Integer student_id, @RequestParam Integer test_id) {
        studentTestService.addTries(student_id, test_id);
    }

    @PutMapping(path = "/passing")
    public void passing(@RequestParam Integer student_id, @RequestParam Integer test_id) {
        studentTestService.passing(student_id, test_id);
    }

    @GetMapping(path = "/failed")
    public List<Object[]> getAllFailedStudents() {
        return studentTestService.getAllFailedStudents();
    }

}
