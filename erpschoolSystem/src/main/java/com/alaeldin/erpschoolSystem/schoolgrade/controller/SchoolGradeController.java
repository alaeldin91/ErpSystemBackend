package com.alaeldin.erpschoolSystem.schoolgrade.controller;


import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;
import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;
import com.alaeldin.erpschoolSystem.schoolgrade.servieImpl.SchoolGradeServiceImpl;
import com.alaeldin.erpschoolSystem.security.serviceimpl.user.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/admin/schoolGrade")
public class SchoolGradeController {
    Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private  final SchoolGradeServiceImpl schoolGradeService;

    @GetMapping("/getallschoolGrade")
    public ResponseEntity <List<SchoolGradeDto>> getAllGradeSchool(){
        List<SchoolGradeDto> schoolGradeList = schoolGradeService.getAllSchoolGradeService();
        return new ResponseEntity<>(schoolGradeList, HttpStatus.OK);

    }

    @GetMapping("byid/{id}")
    public ResponseEntity <SchoolGradeDto> getGradeById(@PathVariable("id") long id){
        SchoolGradeDto schoolGradeDto = schoolGradeService.getSchoolGardeById(id);
        return new ResponseEntity<>(schoolGradeDto,HttpStatus.OK);
    }

    @GetMapping("byname/{name}")
    public ResponseEntity<SchoolGradeDto> getGradeSchoolByName(@PathVariable("name")String name){
        SchoolGradeDto schoolGradeDto = schoolGradeService.getSchoolGradeByName(name);
        return new ResponseEntity<>(schoolGradeDto,HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteGradeSchoolById(@PathVariable("id") long id){
          schoolGradeService.deleteSchoolGardeService(id);
          return new ResponseEntity<>("Delete Grade School By Id",HttpStatus.OK);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<SchoolGradeDto> updateGradeSchool(@PathVariable("id")long id,
                                                            @RequestBody @Valid SchoolGradeDto schoolGradeDto){
        schoolGradeDto.setId(id);
        SchoolGradeDto schoolGradeUpdateDto = schoolGradeService.updateGradeService(schoolGradeDto);
        return new ResponseEntity<>(schoolGradeUpdateDto,HttpStatus.OK);
    }


}
