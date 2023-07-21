package com.alaeldin.erpschoolSystem.country.country.Service;


import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import org.springframework.data.domain.Page;

import java.util.List;


public interface Service {
    Iterable<Country> listCountryDao(List<Country> countryDaoList);
    Iterable<CountryDto>getAllCountry(int pageNumber,int pageSize);
    List<CountryDto> getCountryByName(String countryName);
}
