package com.alaeldin.erpschoolSystem.schoolgrade.service;

import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;

import java.util.List;

public interface SchoolGradeService {
    List<SchoolGradeDto> getAllSchoolGradeService();
   Iterable <SchoolGradeDto> saveAllGradeService(List<SchoolGradeDto> schoolGradeDtoList);
    SchoolGradeDto updateGradeService(SchoolGradeDto schoolGradeDto);
    void deleteSchoolGardeService(long id);
    SchoolGradeDto getSchoolGradeByName(String name);
    SchoolGradeDto getSchoolGardeById(long id);

}
