package dev.jrn.exam_system.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentTestId implements Serializable{
    
    @Column(nullable = false, name = "student_id")
    private Integer student_id;
    @Column(nullable = false, name = "test_id")
    private Integer test_id;
    
    public StudentTestId(Integer student_id, Integer test_id) {
        this.student_id = student_id;
        this.test_id = test_id;
    }

    public StudentTestId() { }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    @Override
    public String toString() {
        return "StudentTestId [student_id=" + student_id + ", test_id=" + test_id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((student_id == null) ? 0 : student_id.hashCode());
        result = prime * result + ((test_id == null) ? 0 : test_id.hashCode());
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
        StudentTestId other = (StudentTestId) obj;
        if (student_id == null) {
            if (other.student_id != null)
                return false;
        } else if (!student_id.equals(other.student_id))
            return false;
        if (test_id == null) {
            if (other.test_id != null)
                return false;
        } else if (!test_id.equals(other.test_id))
            return false;
        return true;
    }

    

}
