package com.alaeldin.erpschoolSystem.country.country.entity;

import com.alaeldin.erpschoolSystem.country.town.entity.City;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id",
        scope=Country.class)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private Long countryId;
    @Column(nullable = false, unique = true, length = 300)
    private String name;
    @Column(name = "name2", length = 300)
    private String name2;
    @Column(length = 3)
    private String alpha2Code;
    @Column(length = 3)
    private String alpha3Code;
    @Column(length = 3)
    private String hieCode;
    @Column(length = 2000)
    private String hieDesc;
    @Column(length = 2000)
    private String hieNationalityDesc;
    @OneToMany()
    private Set<City> cities;
}

