package dev.jrn.exam_system.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String test_name;
    private Boolean pruef;

    @JsonIgnore
    @OneToMany(
        mappedBy = "test",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<StudentTest> students = new ArrayList<>();

    public Test() { }

    public Test(String test_name) { this.test_name = test_name; }

    public Test(Integer id, String test_name, Boolean pruef) {
        this.id = id;
        this.test_name = test_name;
        this.pruef = pruef;
    }

    public Test(String test_name, Boolean pruef) {
        this.test_name = test_name;
        this.pruef = pruef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public Boolean getPruef() {
        return pruef;
    }

    public void setPruef(Boolean pruef) {
        this.pruef = pruef;
    }

    @Override
    public String toString() {
        return "Test [id=" + id + ", test_name=" + test_name + ", pruef=" + pruef + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((test_name == null) ? 0 : test_name.hashCode());
        result = prime * result + ((pruef == null) ? 0 : pruef.hashCode());
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
        Test other = (Test) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (test_name == null) {
            if (other.test_name != null)
                return false;
        } else if (!test_name.equals(other.test_name))
            return false;
        if (pruef == null) {
            if (other.pruef != null)
                return false;
        } else if (!pruef.equals(other.pruef))
            return false;
        return true;
    }

    

    
}
