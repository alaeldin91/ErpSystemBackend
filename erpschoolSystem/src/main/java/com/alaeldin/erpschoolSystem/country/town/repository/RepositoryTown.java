package com.alaeldin.erpschoolSystem.country.town.repository;


import com.alaeldin.erpschoolSystem.country.town.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryTown extends JpaRepository<City,Long> {
 List<City> findByCountryId(Long country);

 Optional<City> findByName(String name);
}
