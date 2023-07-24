package com.alaeldin.erpschoolSystem.country.town.service;


import com.alaeldin.erpschoolSystem.country.town.dto.CityDto;
import com.alaeldin.erpschoolSystem.country.town.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TownService {
    /**
     * function Save All Cities
     * @param countryList
     * @return
     */
    Iterable<City>saveAllCities(List<City> countryList);

    /**
     *  function get All Town
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<CityDto> getAllTown(int pageNumber, int pageSize);

    /**
     * function get City By Country
     * @param countryName
     * @return
     */
    List <CityDto> getCityByCountry(Long countryName);

    /**
     *  function get City By Name
     * @param cityName
     * @return
     */
    CityDto getCityByName(String cityName);

    /**
     * Function Delete By id
     * @param id
     */
  void deleteCity(long id);

    /**
     * function Update City
     * @param cityDto
     * @return
     */
 CityDto updateCity(CityDto cityDto);
}
