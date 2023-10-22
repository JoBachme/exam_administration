package dev.jrn.exam_system.entity;

public class StudentTestQueryProjection {

    String first_name;
    String last_name;
    String test_name;
    Boolean passed_flag;
    Integer tries;

    public StudentTestQueryProjection(String first_name, String last_name, String test_name, Boolean passed_flag,
            Integer tries) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.test_name = test_name;
        this.passed_flag = passed_flag;
        this.tries = tries;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
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

    @Override
    public String toString() {
        return "StudentTestQueryProjection [first_name=" + first_name + ", last_name=" + last_name + ", test_name="
                + test_name + ", passed_flag=" + passed_flag + ", tries=" + tries + "]";
    }

    
}
