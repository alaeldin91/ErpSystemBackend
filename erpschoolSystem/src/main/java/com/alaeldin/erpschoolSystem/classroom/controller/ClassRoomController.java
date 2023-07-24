package com.alaeldin.erpschoolSystem.classroom.controller;

import com.alaeldin.erpschoolSystem.classroom.dto.ClassRoomDto;
import com.alaeldin.erpschoolSystem.classroom.serviceimpl.ClassRoomServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/class")
public class ClassRoomController {
   private final ClassRoomServiceImpl classRoomService;

    @GetMapping(params = { "page", "size"})
    public ResponseEntity<Page<ClassRoomDto>> getAllClassRoom(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<ClassRoomDto> classRoomDtoList = classRoomService.getClassRoom(page,size);
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
