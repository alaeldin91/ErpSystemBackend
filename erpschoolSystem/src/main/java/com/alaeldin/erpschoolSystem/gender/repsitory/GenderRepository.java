package com.alaeldin.erpschoolSystem.gender.repsitory;

import com.alaeldin.erpschoolSystem.gender.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository  extends JpaRepository<Gender,Long> {
    Optional<Gender> findByName(String name);
}
