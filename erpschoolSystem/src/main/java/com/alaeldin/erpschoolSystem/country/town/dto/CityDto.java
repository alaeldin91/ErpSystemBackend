package com.alaeldin.erpschoolSystem.country.town.dto;


import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CityDto {

    private long id;
    private String name;
    private String name2;
    private String hieCode;
    private String hieDesc;
    private  String dohCode;
    private Country country;
    private long country_id;

}
