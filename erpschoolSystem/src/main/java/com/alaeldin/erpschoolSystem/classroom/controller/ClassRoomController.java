package com.alaeldin.erpschoolSystem.classroom.controller;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.serviceimpl.ClassRoomServiceImpl;
import com.alaeldin.erpschoolSystem.security.serviceimpl.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/admin/class")
public class ClassRoomController {
    Logger logger = LogManager.getLogger(UserServiceImpl.class);
   private final ClassRoomServiceImpl classRoomService;
   @GetMapping
    public ResponseEntity<List<ClassRoomDto>> getAllClassRoom(){
        List<ClassRoomDto> classRoomDtoList = classRoomService.getClassRoom();
        return  new ResponseEntity<>(classRoomDtoList, HttpStatus.OK);
   }

   @GetMapping("{name}")
    public ResponseEntity<ClassRoomDto> getClassRoomByName(@PathVariable("name") String name){
       ClassRoomDto classRoomDto = classRoomService.getClassRoomByName(name);
       return new ResponseEntity<>(classRoomDto,HttpStatus.OK);
   }
   @GetMapping("byId/{id}")
    public ResponseEntity<ClassRoomDto> getClassRoomById(@PathVariable("id") long id){
       ClassRoomDto classRoomDto = classRoomService.getClassById(id);
       return new ResponseEntity<>(classRoomDto,HttpStatus.OK);
   }

}
