package dev.jrn.exam_system.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jrn.exam_system.entity.Student;
import dev.jrn.exam_system.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() { return studentRepository.findAll(); }

    public Optional<Student> getStudentById(Integer student_id) { return studentRepository.findById(student_id); }

    public void deleteStudentById(Integer student_id) {
        if (!studentRepository.existsById(student_id)) { throw new IllegalStateException("Student does not exist!"); }
        studentRepository.deleteById(student_id);
    }

    public void addNewStudent(Student student) {
        Optional <Student> studentOptional = studentRepository.findStudentByName(student.getFirst_name(), student.getLast_name());

        if (studentOptional.isPresent()) { throw new IllegalStateException("Name taken"); }
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Integer student_id, String first_name, String last_name) {
        Student student = studentRepository.findById(student_id).orElseThrow(() -> new IllegalStateException("Student does not exist"));

        if ((first_name != null && first_name.length() > 0
                && !Objects.equals(student.getFirst_name(), first_name))
                || (last_name != null && last_name.length() > 0
                && !Objects.equals(student.getLast_name(), last_name))) 
            { 
            Optional<Student> studentOptional = studentRepository.findStudentByName(first_name, last_name);
            if (studentOptional.isPresent()) { throw new IllegalStateException("Name already taken"); }
            if (first_name != null) { student.setFirst_name(first_name); }
            if (last_name != null) { student.setLast_name(last_name); }
        }
    }
}
