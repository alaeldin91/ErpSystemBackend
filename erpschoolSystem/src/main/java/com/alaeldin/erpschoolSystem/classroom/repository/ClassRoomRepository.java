package com.alaeldin.erpschoolSystem.classroom.repository;

import com.alaeldin.erpschoolSystem.classroom.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long> {
    Optional<ClassRoom> findByName(String name);
}
