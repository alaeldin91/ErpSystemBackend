package com.alaeldin.erpschoolSystem.country.country.Service;


import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import com.alaeldin.erpschoolSystem.country.country.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor

public class CountryService implements Service{
    private final CountryRepository countryRepository;

    /**
     * function listCountryDao
     * @param countryList
     * @return
     */
    @Override
    public Iterable<Country> listCountryDao(List<Country> countryList) {
  for (int i=0;i<=countryList.size();i++) {
      if (countryRepository.existsByName(countryList.get(i).getName())) {
          List<Country> existName  = countryRepository.findByName(countryList.get(i).getName()).orElseThrow();
         return countryRepository.saveAll(existName);

      }
  }
  return countryRepository.saveAll(countryList);


    }

    /**
     * function getAllCountry
     * @return
     */
    @Override
    public Page<CountryDto> getAllCountry(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Country> countries = countryRepository.findAll(pageable);
        Page<CountryDto>countryDto = countries.map(country -> new CountryDto(
                country.getId()
                 ,country.getCountryId()
                 ,country.getName()
                 ,country.getName2()
                 ,country.getAlpha2Code()
                 ,country.getAlpha3Code()
                 ,country.getHieCode()
                 ,country.getHieDesc()
                 ,country.getHieNationalityDesc()
                 ,country.getCities()))
                  ;
        return countryDto;
    }

    /**
     * get CountryByName
     * @param countryName
     * @return countryDto
     */
    @Override
    public List<CountryDto> getCountryByName(String countryName) {
        List<Country> country = countryRepository.findByName(countryName).orElseThrow();
        List<CountryDto> countryDto = country.stream().map(country1 ->new CountryDto(
                 country1.getId()
                ,country1.getCountryId()
                ,country1.getName()
                ,country1.getName2()
                ,country1.getAlpha2Code()
                ,country1.getAlpha3Code()
                ,country1.getHieCode()
                ,country1.getHieDesc()
                ,country1.getHieNationalityDesc()
                ,country1.getCities()))
                .toList();
        return countryDto;
    }
}
