package com.alaeldin.erpschoolSystem.gender.mapper;

import com.alaeldin.erpschoolSystem.gender.dto.GenderDto;
import com.alaeldin.erpschoolSystem.gender.entity.Gender;

public class GenderMapper {
    public static GenderDto toGenderDto(Gender gender){
        GenderDto genderDto = new GenderDto(gender.getId(),gender.getName(),gender.getName2());
        return genderDto;
    }

    public static Gender toGender(GenderDto genderDto){
        Gender gender = new Gender(genderDto.getId(), genderDto.getName(), genderDto.getName2());
        return  gender;
    }
}
