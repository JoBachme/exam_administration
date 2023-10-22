package dev.jrn.exam_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.jrn.exam_system.entity.StudentTest;
import dev.jrn.exam_system.entity.StudentTestId;

@Repository
public interface StudentTestRepository extends JpaRepository<StudentTest, StudentTestId> {
    
    public StudentTest findByStudentTestId(StudentTestId studentTestId);

    @Query(value = "SELECT * FROM students_tests st", nativeQuery = true)
    public List<StudentTest> getAllCombinations();

    @Query(value = "SELECT * FROM students_tests st WHERE st.student_id=?1 and st.test_id=?2", nativeQuery = true)
    public StudentTest getCombination(Integer student_id, Integer test_id);

    @Query(value = "SELECT s.first_name, s.last_name, t.test_name, st.passed_flag, st.tries FROM students as s\n" + //
            "INNER JOIN students_tests AS st ON s.id = st.student_id\n" + //
            "INNER JOIN tests AS t ON st.test_id = t.id\n" + //
            "WHERE s.id = ?1 ORDER BY st.tries", nativeQuery = true)
    public List<Object[]> findAllByStudent_id(Integer student_id);

    @Query(value = "SELECT s.first_name, s.last_name, t.test_name, st.passed_flag, st.tries FROM tests as t\n" + //
            "INNER JOIN students_tests AS st ON t.id = st.test_id\n" + //
            "INNER JOIN students AS s ON st.student_id = s.id\n" + //
            "WHERE t.id = ?1 ORDER BY st.tries" , nativeQuery = true)
    public List<Object[]> findAllByTest_id(Integer test_id);

    @Query(value = "SELECT st.passed_flag FROM students_tests as st\n" + //
            "INNER JOIN tests AS t ON st.test_id = t.id\n" + //
            "INNER JOIN students AS s ON st.student_id = s.id\n" + //
            "WHERE t.id = ?2 and s.id = ?1 and st.passed_flag = true", nativeQuery = true)
    public Boolean hasPassed(Integer student_id, Integer test_id);

    @Query(value = "SELECT s.first_name, s.last_name, t.test_name, st.passed_flag, st.tries FROM students as s\n" + //
            "INNER JOIN students_tests AS st ON s.id = st.student_id\n" + //
            "INNER JOIN tests AS t ON st.test_id = t.id\n" + //
            "WHERE st.tries = 3", nativeQuery = true)
    public List<Object[]> getAllFailedStudents();

}
