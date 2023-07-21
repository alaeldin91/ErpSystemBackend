package com.alaeldin.erpschoolSystem.country.country.dto;

import com.alaeldin.erpschoolSystem.country.town.entity.City;
import lombok.*;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private long id;
    private Long countryId;
    private String name;
    private String name2;
    private String alpha2Code;
    private String alpha3Code;
    private String hieCode;
    private String hieDesc;
    private String hieNationalityDesc;
    private Set<City> cities;
}
