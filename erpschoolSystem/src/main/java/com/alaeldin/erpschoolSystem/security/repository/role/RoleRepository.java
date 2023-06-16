package com.alaeldin.erpschoolSystem.security.repository.role;

import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    //Optional<Role> findByRole(String roleName);
    Optional<Role> findByRoleName(String roleName);
   // Optional<Role>findByRoleNameContaining(String roleName,Pageable pageable);


}
