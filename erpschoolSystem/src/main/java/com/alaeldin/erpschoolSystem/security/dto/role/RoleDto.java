package com.alaeldin.erpschoolSystem.security.dto.role;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Integer id;
    @NotEmpty(message = "Role role Name should not be null or empty")
    private String roleName;
    @NotEmpty(message = "Role role Description should not be null or empty")
    private String roleDescription;
}
