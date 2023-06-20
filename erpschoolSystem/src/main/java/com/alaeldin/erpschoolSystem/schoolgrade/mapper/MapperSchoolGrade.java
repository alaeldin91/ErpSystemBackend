package com.alaeldin.erpschoolSystem.schoolgrade.mapper;

import com.alaeldin.erpschoolSystem.schoolgrade.dto.SchoolGradeDto;
import com.alaeldin.erpschoolSystem.schoolgrade.entity.SchoolGrade;

public class MapperSchoolGrade {
    public static SchoolGradeDto toSchoolGradeDto(SchoolGrade schoolGrade){
         SchoolGradeDto schoolGradeDto = new SchoolGradeDto(schoolGrade.getId(),
                 schoolGrade.getName());
         return schoolGradeDto;
    }

    public static SchoolGrade toSchoolGrade(SchoolGradeDto schoolGradeDto){
        SchoolGrade schoolGrade = new SchoolGrade(
                schoolGradeDto.getId(),
                schoolGradeDto.getName()
        );
        return schoolGrade;
    }
}
