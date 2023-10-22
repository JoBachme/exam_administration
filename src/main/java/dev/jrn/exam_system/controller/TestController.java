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

import dev.jrn.exam_system.entity.Test;
import dev.jrn.exam_system.service.TestService;

@RestController
@RequestMapping(path = "api/v1/test")
public class TestController {
    
    @Autowired
    private TestService testService;

    @GetMapping(path = "/all")
    public List<Test> fetchAllTests() { return testService.getAllTests(); }

    @GetMapping(path = "/id")
    public Optional<Test> getTestById(@RequestParam Integer test_id) {
        return testService.getStudentById(test_id);
    }

    @DeleteMapping(path = "{test_id}")
    public void deleteTestById(@PathVariable("test_id") Integer test_id) {
        testService.deleteTestById(test_id);
    }

    @PostMapping
    public void addNewTest(@RequestBody Test test) { testService.addNewTest(test); }


    @PutMapping(path = "{test_id}")
    public void updateTest(@PathVariable("test_id") Integer test_id, @RequestParam(required = false) String test_name) {
        testService.updateTest(test_id, test_name);
    }

    @PutMapping(path = "/pruef")
    public void updatePruef(@RequestParam Integer test_id) {
        testService.updatePruef(test_id);
    }
}
