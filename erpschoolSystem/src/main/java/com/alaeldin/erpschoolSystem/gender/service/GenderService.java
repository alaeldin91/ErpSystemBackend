package com.alaeldin.erpschoolSystem.gender.service;

import com.alaeldin.erpschoolSystem.gender.dto.GenderDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GenderService {
    /**
     * function Save all Gender
     * @param genderDto
     * @return
     */
      Iterable<GenderDto> saveAll(List<GenderDto> genderDto);

    /**
     * function Get All Gender
     * @param pageNumber
     * @param pageSize
     * @return
     */
      Page<GenderDto> getAllGender(int pageNumber,int pageSize);

    /**
     * Get Gender By Id
     * @param id
     * @return
     */
      GenderDto getGenderById(long id);

    /**
     * Get Gender By Name
     * @param name
     * @return
     */
    GenderDto getGenderByName(String name);

    /**
     * Update Gender
     * @param genderDto
     * @return
     */
    GenderDto updateGender(GenderDto genderDto);

    /**
     * Delete Gender By Id
     * @param id
     */
    void deleteGender(long id);
}
