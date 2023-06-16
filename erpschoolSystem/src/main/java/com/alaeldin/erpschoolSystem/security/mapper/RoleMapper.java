package com.alaeldin.erpschoolSystem.security.mapper;

import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role){
         RoleDto roleDto = new RoleDto(
                 role.getId(),
                 role.getRoleName(),
                 role.getRoleDescription()
         );
         return roleDto;
    }
    public static Role mapToRole(RoleDto roleDto){
        Role role = new Role(roleDto.getId()
                , roleDto.getRoleName(),
                roleDto.getRoleDescription());
        return  role;
    }
}
