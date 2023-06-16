package com.alaeldin.erpschoolSystem.security.dto.user.request;

import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;
}
