package com.alaeldin.erpschoolSystem.subject.controller;


import com.alaeldin.erpschoolSystem.subject.dto.SubjectDto;
import com.alaeldin.erpschoolSystem.subject.entity.Subject;
import com.alaeldin.erpschoolSystem.subject.serviceimpl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/subject")
@RequiredArgsConstructor
public class SubjectController {
private final SubjectServiceImpl subjectService;

   @PostMapping
    public ResponseEntity<SubjectDto> saveSubjectDto(@RequestBody SubjectDto subjectDto){
    SubjectDto saveSubjectDto = subjectService.saveSubjectDto(subjectDto);
    return new ResponseEntity<>(saveSubjectDto, HttpStatus.OK);
   }

   @GetMapping(value = "/getAllsubject",params = {"pageNumber","pageSize"})
    public ResponseEntity<Page<SubjectDto>> getAllSubject(@RequestParam("pageNumber") int pageNumber
           ,@RequestParam("pageSize")int pageSize){
       Page<SubjectDto> subjectList = subjectService.getAllSubject(pageNumber,pageSize);
       return new ResponseEntity<>(subjectList,HttpStatus.OK);

   }

   @GetMapping("byid/{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") long id){
       SubjectDto subjectDto = subjectService.getSubjectById(id);
       return new ResponseEntity<>(subjectDto,HttpStatus.OK);
   }
   @GetMapping("bysubjectid/{subjectId}")

    public ResponseEntity<SubjectDto> getSubjectBySubjectId(@PathVariable("subjectId") int subjectId){
       SubjectDto subjectDto = subjectService.getSubjectBySubjectId(subjectId);
       return new ResponseEntity<>(subjectDto,HttpStatus.OK);
   }

   @GetMapping("bysubectname/{subjectName}")

    public ResponseEntity<SubjectDto> getSubjectByName(@PathVariable("subjectName") String subjectName){
        SubjectDto subjectDtoByName = subjectService.getSubjectByName(subjectName);
        return new ResponseEntity<>(subjectDtoByName,HttpStatus.OK);
   }

   @PostMapping("update/{id}")
    public  ResponseEntity<SubjectDto>updateSubject(@PathVariable("id")long id,@RequestBody SubjectDto subjectDto){
       subjectDto.setId(id);
       SubjectDto subjectSaveDto = subjectService.updateSubject(subjectDto);
       return new ResponseEntity<>(subjectSaveDto,HttpStatus.OK);
   }

   @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") long id){
       subjectService.deleteSubject(id);
       return new ResponseEntity<>("the Successfully Delete",HttpStatus.OK);
   }

}
