package com.alaeldin.erpschoolSystem.country.town.service.impl;


import com.alaeldin.erpschoolSystem.country.town.Mapper.TownMapper;
import com.alaeldin.erpschoolSystem.country.town.dto.CityDto;
import com.alaeldin.erpschoolSystem.country.town.entity.City;
import com.alaeldin.erpschoolSystem.country.town.repository.RepositoryTown;
import com.alaeldin.erpschoolSystem.country.town.service.TownService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TownServiceImpl implements TownService {
    private final RepositoryTown repositoryTown;
    @Override
    public Iterable<City> saveAllCities(List<City> cityList) {
        return repositoryTown.saveAll(cityList);
    }

    @Override
    public Page<CityDto> getAllTown(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<City> cityList = repositoryTown.findAll(pageable);
        Page<CityDto> cityDto = cityList.map(city -> new CityDto(city.getId()
                                                                          ,city.getName()
                                                                          , city.getName2()
                                                                          ,city.getHieCode()
                                                                          , city.getHieDesc()
                                                                          ,city.getDohCode()
                                                                          ,city.getCountry()
                                                                          , city.getCountry_id()));
                  return cityDto;
    }

    @Override
    public List<CityDto> getCityByCountry(Long countryId) {
      List <City> cityList =  repositoryTown.findByCountryId(countryId);
        List<CityDto> cityDto = cityList.stream().map(city -> new CityDto(city.getId()
                                                                           ,city.getName()
                                                                           ,city.getName2()
                                                                           ,city.getHieCode()
                                                                           ,city.getHieDesc()
                                                                           ,city.getDohCode()
                                                                           ,city.getCountry()
                                                                           ,city.getCountry_id()))
                                                                           .toList();

                         return cityDto;
    }

    @Override
    public CityDto getCityByName(String cityName) {
             City city = repositoryTown
                    .findByName(cityName)
                    .orElseThrow();
             return TownMapper.mapToCityDto(city);
    }


}
