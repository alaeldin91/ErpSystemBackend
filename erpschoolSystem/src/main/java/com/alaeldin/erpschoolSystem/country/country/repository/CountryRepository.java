package com.alaeldin.erpschoolSystem.country.country.repository;


import com.alaeldin.erpschoolSystem.country.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository  extends JpaRepository<Country,Long> {

    boolean existsByName(String name);

    Optional<List<Country>> findByName(String name);
}
