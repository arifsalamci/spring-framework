package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findByCountry(String country);

    List<Region> findDistinctByCountry(String country);

    List<Region> findByCountryContains(String country);

    List<Region> findByCountryContainsOrderByCountry(String country);

    List<Region> findTop2ByCountry(String country);


}
