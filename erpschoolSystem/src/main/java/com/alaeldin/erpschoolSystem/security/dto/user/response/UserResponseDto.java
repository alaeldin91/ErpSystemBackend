package com.alaeldin.erpschoolSystem.security.dto.user.response;

import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private int id;
private String token;
private String lastName;
private String firstName;
private String email;
private Set<Role> role;


}
