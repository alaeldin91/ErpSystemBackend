package com.alaeldin.erpschoolSystem.security.service.user;



import com.alaeldin.erpschoolSystem.security.dto.user.request.UserLoginRequest;
import com.alaeldin.erpschoolSystem.security.dto.user.request.UserRegisterRequestDto;
import com.alaeldin.erpschoolSystem.security.dto.user.response.UserResponseDto;
import com.alaeldin.erpschoolSystem.security.entity.user.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService {
  UserResponseDto register(UserRegisterRequestDto userRegisterRequestDto);
  UserResponseDto authenticate(UserLoginRequest userRegisterRequestDto);
     void deleteAccount(Integer id);
     Page<User> getAllAccount(int page,int size);
     User getUserByEmail(String email);
     UserResponseDto validateToken(String token);
     UserResponseDto updateUser(UserRegisterRequestDto userResponseDto);
}
