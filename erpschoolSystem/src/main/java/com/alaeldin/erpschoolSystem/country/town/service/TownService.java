package com.alaeldin.erpschoolSystem.country.town.service;


import com.alaeldin.erpschoolSystem.country.town.dto.CityDto;
import com.alaeldin.erpschoolSystem.country.town.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TownService {
Iterable<City>saveAllCities(List<City> countryList);
Page<CityDto> getAllTown(int pageNumber, int pageSize);
List <CityDto> getCityByCountry(Long countryName);
CityDto getCityByName(String cityName);


}
