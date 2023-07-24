package com.alaeldin.erpschoolSystem.country.country.controll;

import com.alaeldin.erpschoolSystem.country.country.Service.CountryServiceImpl;
import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/counteries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryServiceImpl countryServiceImpl;

    @GetMapping(params = {"pageNumber","pageSize"})
    public ResponseEntity<Page<CountryDto>> getAllCountry(@RequestParam("pageNumber")int pageNumber,@RequestParam("pageSize") int pageSize) {

        Page<CountryDto> countryDto = countryServiceImpl.getAllCountry(pageNumber,pageSize);
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<List<CountryDto>> getCountryByName(@PathVariable("countryName") String countryName) {
        List<CountryDto> countryDtoList = countryServiceImpl.getCountryByName(countryName);
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }
  @GetMapping("country/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable("id") long id){
         CountryDto countryDto = countryServiceImpl.getCountryById(id);
         return new ResponseEntity<>(countryDto,HttpStatus.OK);
  }

  @PostMapping("update/country/{id}")
    public ResponseEntity<CountryDto> updateCountry(CountryDto countryDto,@PathVariable("id") long id){
        countryDto.setId(id);
        CountryDto updateCountry = countryServiceImpl.updateCountry(countryDto);
        return new ResponseEntity<>(updateCountry,HttpStatus.OK);
    }

    @GetMapping("delete/country/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable("id") long id){
         countryServiceImpl.countryDelete(id);
         return new ResponseEntity<>("Delete Country Successfully",HttpStatus.OK);
    }
}
