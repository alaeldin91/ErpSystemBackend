package com.alaeldin.erpschoolSystem.gender.controller;

import com.alaeldin.erpschoolSystem.gender.dto.GenderDto;
import com.alaeldin.erpschoolSystem.gender.servicelmpl.GenderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/genders")
public class GenderController {
    private final GenderServiceImpl genderService;

  @GetMapping(params = {"pageNumber","pageSize"})
    public ResponseEntity<Page<GenderDto>> getAllGender(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
      Page<GenderDto> genderDtoPage = genderService.getAllGender(pageNumber,pageSize);
      return new ResponseEntity<>(genderDtoPage, HttpStatus.OK);
  }

  @GetMapping("/{id}")
    public ResponseEntity<GenderDto> getGenderById(@PathVariable("id") long id){
      GenderDto genderDto = genderService.getGenderById(id);
      return new ResponseEntity<>(genderDto,HttpStatus.OK);
  }

  @GetMapping("gender/{name}")
    public ResponseEntity<GenderDto> getGenderByName(@PathVariable("name") String name){
       GenderDto genderDto = genderService.getGenderByName(name);
       return new ResponseEntity<>(genderDto,HttpStatus.OK);
  }

  @GetMapping("gender/delete/{id}")
    public ResponseEntity<String> deleteGenderById(@PathVariable("id") long id){
      genderService.deleteGender(id);
      return new ResponseEntity<>("Delete Gender Successfully",HttpStatus.OK);
  }
 @PostMapping("gender/update/{id}")
    public ResponseEntity<GenderDto> updateGender(GenderDto genderDto,long id){
      genderDto.setId(id);
      GenderDto updateGender = genderService.updateGender(genderDto);
      return new ResponseEntity<>(updateGender,HttpStatus.OK);
 }
}
