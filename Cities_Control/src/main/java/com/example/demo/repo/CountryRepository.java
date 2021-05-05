package com.example.demo.repo;

import com.example.demo.model.Country;
import com.example.demo.model.city;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
   @Query
    public Country deleteCountryById(Integer id);
}
