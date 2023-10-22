package dev.jrn.exam_system.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jrn.exam_system.entity.Test;
import dev.jrn.exam_system.repository.TestRepository;

@Service
public class TestService {
    
    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTests() { return testRepository.findAll(); }

    public Optional<Test> getStudentById(Integer test_id) { return testRepository.findById(test_id); }

    public void deleteTestById(Integer test_id) {
        if (!testRepository.existsById(test_id)) { throw new IllegalStateException("Test does not exist!"); }
        testRepository.deleteById(test_id);
    }

    public void addNewTest(Test test) {
        Optional <Test> testOptional = testRepository.findTestByName(test.getTest_name());

        if (testOptional.isPresent()) { throw new IllegalStateException("Name taken"); }
        testRepository.save(test);
    }

    @Transactional
    public void updateTest(Integer test_id, String test_name) {
        Test test = testRepository.findById(test_id).orElseThrow(() -> new IllegalStateException("test does not exist"));

        if (test_name != null && test_name.length() > 0
                && !Objects.equals(test.getTest_name(), test_name)) { 
            Optional<Test> testOptional = testRepository.findTestByName(test_name);
            if (testOptional.isPresent()) { throw new IllegalStateException("Name already taken"); }
            test.setTest_name(test_name);
        }
    }

    @Transactional
    public void updatePruef(Integer test_id) {
        Test test = testRepository.findById(test_id).orElseThrow(() -> new IllegalStateException("test does not exist"));
        test.setPruef(!test.getPruef());
    }
}
