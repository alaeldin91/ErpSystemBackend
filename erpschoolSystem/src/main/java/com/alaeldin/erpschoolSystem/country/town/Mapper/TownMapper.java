package com.alaeldin.erpschoolSystem.country.town.Mapper;


import com.alaeldin.erpschoolSystem.country.town.dto.CityDto;
import com.alaeldin.erpschoolSystem.country.town.entity.City;

public class TownMapper {
    public static CityDto mapToCityDto(City city){
        CityDto cityDto = new CityDto(city.getId()
                                        ,city.getName()
                                        ,city.getName2()
                                        ,city.getHieCode()
                                        ,city.getHieDesc()
                                        ,city.getDohCode()
                                        ,city.getCountry()
                                        ,city.getCountry_id());
                return cityDto;
    }
    public City mapToCity(CityDto cityDto){
        City city = new City(cityDto.getId()
                            ,cityDto.getName()
                            ,cityDto.getName2()
                            ,cityDto.getHieCode()
                            ,cityDto.getHieDesc()
                            ,cityDto.getDohCode()
                            ,cityDto.getCountry()
                            ,cityDto.getCountry_id());
             return city;
    }
}
