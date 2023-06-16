package com.alaeldin.erpschoolSystem.security.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    private Integer id;
    private String email;
    private String password;

}
