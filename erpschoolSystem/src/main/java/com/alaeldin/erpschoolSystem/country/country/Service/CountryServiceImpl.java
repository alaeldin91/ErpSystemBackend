package com.alaeldin.erpschoolSystem.country.country.Service;


import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import com.alaeldin.erpschoolSystem.country.country.repository.CountryRepository;
import com.alaeldin.erpschoolSystem.country.town.entity.City;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor

public class CountryServiceImpl implements CountryService{
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

    @Override
    public CountryDto updateCountry(CountryDto countryDto) {
          Country existCountry = countryRepository.findById(countryDto.getId())
                  .orElseThrow(()-> new ResourceNotFoundException("country","id",(int)countryDto.getId()));
          existCountry.setId(countryDto.getId());
          existCountry.setCountryId(countryDto.getCountryId());
          existCountry.setName(countryDto.getName());
          existCountry.setName2(countryDto.getName2());
          existCountry.setAlpha2Code(countryDto.getAlpha2Code());
          existCountry.setAlpha3Code(countryDto.getAlpha3Code());
          existCountry.setHieCode(countryDto.getHieCode());
          existCountry.setHieDesc(countryDto.getHieDesc());
         existCountry.setHieNationalityDesc(countryDto.getHieNationalityDesc());
          existCountry.setCities(countryDto.getCities());
          Country saveCountry = countryRepository.save(existCountry);
          CountryDto countrySaveDto= new CountryDto(saveCountry.getId(),
                  saveCountry.getCountryId(),
                  saveCountry.getName(),
                  saveCountry.getName2(),
                  saveCountry.getAlpha2Code(),
                  saveCountry.getAlpha3Code(),
                  saveCountry.getHieCode(),
                  saveCountry.getHieDesc(),
                  saveCountry.getHieNationalityDesc(),
                  saveCountry.getCities());
        return  countrySaveDto;
    }

    @Override
    public CountryDto getCountryById(long id) {
        Country country = countryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("city","id",(int)id));
        CountryDto countryDto =  new CountryDto(country.getId(),
                country.getCountryId(),
                country.getName(),
                country.getName2(),
                country.getAlpha2Code(),
                country.getAlpha3Code(),
                country.getHieCode(),
                country.getHieDesc(),
                country.getHieNationalityDesc(),
                country.getCities());
        return countryDto;
    }

    @Override
    public void countryDelete(long id) {
   Country existCountry = countryRepository.findById(id).orElseThrow(()
           ->new ResourceNotFoundException("countryName","id",(int)id));
     countryRepository.delete(existCountry);
    }
}
