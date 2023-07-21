package com.alaeldin.erpschoolSystem.security.service.role;


import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {
    Page<RoleDto> getAllRole(int pageNumber,int sizeNumber);
   List<RoleDto> getRoleList();
    RoleDto getRoleById(Integer roleId);

    RoleDto saveRole(RoleDto roleDto);

    RoleDto updateRole(RoleDto roleDto);
   RoleDto findByNameContaining(String roleName);
    void deleteRole(Integer id);


}
