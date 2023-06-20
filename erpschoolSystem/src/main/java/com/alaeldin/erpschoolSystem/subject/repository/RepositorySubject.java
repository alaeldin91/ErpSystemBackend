package com.alaeldin.erpschoolSystem.subject.repository;

import com.alaeldin.erpschoolSystem.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorySubject  extends JpaRepository<Subject,Long> {
    Optional<Subject> findBySubjectId(int subjectId);
    Optional<Subject> findBySubjectName(String name);
}
