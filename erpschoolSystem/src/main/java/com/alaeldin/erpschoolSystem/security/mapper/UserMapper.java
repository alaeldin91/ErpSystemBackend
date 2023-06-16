package com.alaeldin.erpschoolSystem.security.mapper;

import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.dto.user.response.UserResponseDto;
import com.alaeldin.erpschoolSystem.security.entity.user.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto touserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());

        userResponseDto.setRole(user.getRoles());
        return  userResponseDto;
    }
    public static  User toUser(UserResponseDto userResponseDto){
        User user = new User();
        user.setId(userResponseDto.getId());
        user.setFirstName(userResponseDto.getFirstName());
        user.setLastName(userResponseDto.getLastName());
        userResponseDto.setEmail(userResponseDto.getEmail());
        return  user;
    }
}
