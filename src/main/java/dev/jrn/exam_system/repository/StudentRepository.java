package dev.jrn.exam_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.jrn.exam_system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.first_name = ?1 and s.last_name = ?2")
    public Optional<Student> findStudentByName(String first_name, String last_name);

}
