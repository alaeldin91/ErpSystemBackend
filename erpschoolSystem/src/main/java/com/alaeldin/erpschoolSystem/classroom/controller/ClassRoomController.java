package com.alaeldin.erpschoolSystem.classroom.controller;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.serviceimpl.ClassRoomServiceImpl;
import com.alaeldin.erpschoolSystem.security.serviceimpl.user.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  @PostMapping("update/{id}")
    public ResponseEntity<ClassRoomDto> updateClassRoom(@PathVariable("id") long id,@RequestBody @Valid ClassRoomDto classRoomDto){
     classRoomDto.setId(id);
       ClassRoomDto updateClassRoom = classRoomService.updateClassRoom(classRoomDto);
       return new ResponseEntity<>(updateClassRoom,HttpStatus.OK);
}

@GetMapping("delete/{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable("id") long id){
     classRoomService.deleteClassRoom(id);
 return new ResponseEntity<>("Successfully Delete Class Room",HttpStatus.OK);
    }

}
