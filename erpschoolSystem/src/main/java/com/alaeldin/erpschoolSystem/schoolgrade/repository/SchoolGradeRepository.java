package com.alaeldin.erpschoolSystem.schoolgrade.repository;

import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolGradeRepository  extends JpaRepository<SchoolGrade,Long> {
Optional<SchoolGrade> findByName(String name);

}
