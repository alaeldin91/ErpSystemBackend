package com.alaeldin.erpschoolSystem.security.controller.user;


import com.alaeldin.erpschoolSystem.security.dto.user.request.UserLoginRequest;
import com.alaeldin.erpschoolSystem.security.dto.user.request.UserRegisterRequestDto;
import com.alaeldin.erpschoolSystem.security.dto.user.response.UserResponseDto;
import com.alaeldin.erpschoolSystem.security.entity.user.User;
import com.alaeldin.erpschoolSystem.security.serviceimpl.user.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {

private final UserServiceImpl userService;
    Logger logger = LogManager.getLogger(UserController.class);

   @PostMapping("/validateToken")
   public ResponseEntity<UserResponseDto> login(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token){
       logger.info("Trying to validate token {}" + token);

       UserResponseDto userResponseDto = userService.validateToken(token);

      logger.info("Trying to validate userResponseDto: " + userResponseDto.getEmail());

       return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
   }

    @PostMapping
    public ResponseEntity<UserResponseDto>register(@RequestBody UserRegisterRequestDto requestDto){
    return  ResponseEntity.ok(userService.register(requestDto));
}
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto>login(@RequestBody UserLoginRequest requestDto){
    return ResponseEntity.ok(userService.authenticate(requestDto));
}
@GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Integer id){
        userService.deleteAccount(id);
        return  new ResponseEntity<>("Successfully Delete Account !", HttpStatus.OK);
}
 @GetMapping(value = "/getAllUsers", params = { "page", "size"})
    public ResponseEntity<Page<User>> getAllAccount(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<User> userResponseDtoList = userService.getAllAccount(page,size);
        return  new ResponseEntity<>(userResponseDtoList,HttpStatus.OK);
 }


 @PostMapping("/update/{id}")
 public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") int id,
                                                   @RequestBody @Valid UserRegisterRequestDto userRegisterRequestDto){
        userRegisterRequestDto.setId(id);
       UserResponseDto userResponseSaveDto = userService.updateUser(userRegisterRequestDto);
       return  new ResponseEntity<>(userResponseSaveDto,HttpStatus.OK);
 }


 @GetMapping("/{email}")
    public ResponseEntity<User>getUserByEmail(@PathVariable("email") String email){
         User user = userService.getUserByEmail(email);
         return new ResponseEntity<>(user,HttpStatus.OK);
 }



}
