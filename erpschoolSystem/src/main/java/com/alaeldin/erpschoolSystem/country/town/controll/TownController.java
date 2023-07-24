package com.alaeldin.erpschoolSystem.country.town.controll;


import com.alaeldin.erpschoolSystem.country.town.dto.CityDto;
import com.alaeldin.erpschoolSystem.country.town.service.impl.TownServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/counteries/towns")
@AllArgsConstructor
public class TownController {
private final TownServiceImpl townService;
    @GetMapping(params = {"pageNumber","pageSize"})
    public ResponseEntity<Iterable<CityDto>> getAllCity(@RequestParam("pageNumber")
                                                            int pageNumber
            ,@RequestParam("pageSize")int pageSize){
        Iterable<CityDto>cityList = townService.getAllTown(pageNumber,pageSize);
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    @GetMapping("/{countryId}")
    public ResponseEntity<List<CityDto>> getTownByCountry(@PathVariable("countryId") Long countryId){
        List<CityDto> city = townService.getCityByCountry(countryId);
                 return new ResponseEntity<>(city,HttpStatus.OK);
    }
   @GetMapping("/town/{cityName}")
    public ResponseEntity<CityDto> getTownByName(@PathVariable("cityName") String cityName){
             CityDto cityDto = townService.getCityByName(cityName);
             return new ResponseEntity<>(cityDto,HttpStatus.OK);
       }

     @PostMapping("update/town/{id}")
     public ResponseEntity<CityDto> updateTown(@PathVariable("id") long id,CityDto cityDto){
        cityDto.setId(id);
     CityDto updateCity = townService.updateCity(cityDto);
     return new ResponseEntity<>(updateCity,HttpStatus.OK);
   }

   @GetMapping("delete/town/{id}")
    public ResponseEntity<String> deleteTown(@PathVariable("id")long id){
          townService.deleteCity(id);
          return new ResponseEntity<>("Delete SuccessFully Town ",HttpStatus.OK);
   }
}
