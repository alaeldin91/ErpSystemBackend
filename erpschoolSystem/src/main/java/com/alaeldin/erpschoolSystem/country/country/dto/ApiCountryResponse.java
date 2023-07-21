package com.alaeldin.erpschoolSystem.country.country.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiCountryResponse {
    private List<CountryDto> countryDtoList;
    private UserResponse userResponse;
}
