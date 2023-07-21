package com.alaeldin.erpschoolSystem.country.country.controll;

import com.alaeldin.erpschoolSystem.country.country.Service.CountryService;
import com.alaeldin.erpschoolSystem.country.country.dto.CountryDto;
import lombok.AllArgsConstructor;
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
    private final CountryService countryService;

    @GetMapping(params = {"pageNumber","pageSize"})
    public ResponseEntity<Page<CountryDto>> getAllCountry(@RequestParam("pageNumber")int pageNumber,@RequestParam("pageSize") int pageSize) {

        Page<CountryDto> countryDto = countryService.getAllCountry(pageNumber,pageSize);
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<List<CountryDto>> getCountryByName(@PathVariable String countryName) {
        List<CountryDto> countryDtoList = countryService.getCountryByName(countryName);
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }

}
