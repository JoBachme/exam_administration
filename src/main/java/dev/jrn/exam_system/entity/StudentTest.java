package dev.jrn.exam_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "students_tests")
public class StudentTest{

    @EmbeddedId
    private StudentTestId studentTestId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("student_id")
    private Student student;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("test_id")
    private Test test;
    
    private Boolean passed_flag;
    private Integer tries;



    public StudentTest() { }

    public StudentTest(StudentTestId studentTestId, Boolean passed_flag, Integer tries) {
        this.studentTestId = studentTestId;
        this.passed_flag = passed_flag;
        this.tries = tries;
    }

    public StudentTest(StudentTestId studentTestId) {
        this.studentTestId = studentTestId;
    }

    public StudentTest(Student student, Test test, Boolean passed_flag, Integer tries) {
        this.student = student;
        this.test = test;
        this.passed_flag = passed_flag;
        this.tries = tries;
        this.studentTestId = new StudentTestId(student.getId(), test.getId());
    }



    public Boolean getPassed_flag() {
        return passed_flag;
    }

    public void setPassed_flag(Boolean passed_flag) {
        this.passed_flag = passed_flag;
    }

    public Integer getTries() {
        return tries;
    }

    public void setTries(Integer tries) {
        this.tries = tries;
    }

    public StudentTestId getStudentTestId() {
        return studentTestId;
    }


    public void setStudentTestId(StudentTestId studentTestId) {
        this.studentTestId = studentTestId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "StudentTest [studentTestId=" + studentTestId + ", student=" + student + ", test=" + test
                + ", passed_flag=" + passed_flag + ", tries=" + tries + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((student == null) ? 0 : student.hashCode());
        result = prime * result + ((test == null) ? 0 : test.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentTest other = (StudentTest) obj;
        if (student == null) {
            if (other.student != null)
                return false;
        } else if (!student.equals(other.student))
            return false;
        if (test == null) {
            if (other.test != null)
                return false;
        } else if (!test.equals(other.test))
            return false;
        return true;
    }

    
    
    

}
