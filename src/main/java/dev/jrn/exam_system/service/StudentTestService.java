package dev.jrn.exam_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jrn.exam_system.entity.StudentTest;
import dev.jrn.exam_system.entity.StudentTestId;
import dev.jrn.exam_system.entity.Test;
import dev.jrn.exam_system.repository.StudentTestRepository;
import dev.jrn.exam_system.repository.TestRepository;

@Service
public class StudentTestService {
    
    @Autowired
    private StudentTestRepository studentTestRepository;

    @Autowired
    private TestRepository testRepository;

    public List<StudentTest> getAllStudentTestCombinations() {
        return studentTestRepository.getAllCombinations();
    }

    public List<Object[]> findAllByStudent_id(Integer s_id) { 
        return studentTestRepository.findAllByStudent_id(s_id);
    }

    public List<Object[]> findAllByTest_id(Integer t_id) {
        return studentTestRepository.findAllByTest_id(t_id);
    }

    public StudentTest getStudentTestCombinationById(StudentTestId studentTestId) {
        return studentTestRepository.findByStudentTestId(studentTestId);
    }

    public Boolean hasPassed(Integer student_id, Integer test_id) {
        if (studentTestRepository.hasPassed(student_id, test_id) == null) { return false; }
        return true;
    }

    @Transactional
    public void addTries(Integer student_id, Integer test_id) {
        StudentTest st = studentTestRepository.getCombination(student_id, test_id);
        Test test = testRepository.findById(test_id).orElseThrow(() -> new IllegalStateException("Test does not exist"));

        if (st != null) {
            if (st.getTries() < 4 && test.getPruef() == true && st.getPassed_flag() == false) {
                st.setTries(st.getTries() + 1);
            } else { new IllegalStateException("Test is not an exam or you already tried this test 3 times"); }
        }
    }

    @Transactional
    public void passing(Integer student_id, Integer test_id) {
        StudentTest st = studentTestRepository.getCombination(student_id, test_id);
        Test test = testRepository.findById(test_id).orElseThrow(() -> new IllegalStateException("Test does not exist"));

        if (st != null) {
            if (st.getTries() < 4 && st.getTries() > 0 && test.getPruef() == true) {
                st.setPassed_flag(true);
            } else { new IllegalStateException("You can only pass the exam if your enrolled and your have tried the test less then 3 times"); }
        }
    }

    public List<Object[]> getAllFailedStudents() {
        return studentTestRepository.getAllFailedStudents();
    }
}
