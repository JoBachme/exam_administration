package dev.jrn.exam_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.jrn.exam_system.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query("SELECT t FROM Test as t WHERE t.test_name = ?1")
    public Optional<Test> findTestByName(String test_name);
}
