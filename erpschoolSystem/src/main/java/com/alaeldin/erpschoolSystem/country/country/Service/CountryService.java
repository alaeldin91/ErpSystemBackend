/**
 * Write 24/7/2023
 * Writer Alaeldin Musa Suliman
 */
package com.alaeldin.erpschoolSystem.country.country.Service;


import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import java.util.List;


public interface CountryService {

    /**
     * Save All ListCountry Dto
     * @param countryDaoList
     * @return
     */
    Iterable<Country> listCountryDao(List<Country> countryDaoList);

    /**
     * Get All Country
     * @param pageNumber
     * @param pageSize
     * @return
     */

    Iterable<CountryDto>getAllCountry(int pageNumber,int pageSize);

    /**
     * Get All Country  By Name
     * @param countryName
     * @return
     */
    List<CountryDto> getCountryByName(String countryName);

    /**
     * function Update Country
     * @param countryDto
     * @return
     */
    CountryDto updateCountry(CountryDto countryDto);

    /**
     * function get Country By id
     * @param id
     * @return
     */
    CountryDto getCountryById(long id);

    /**
     * function Delete By id
     * @param id
     */

    void countryDelete(long id);
}
