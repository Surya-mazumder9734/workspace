package com.example.demo.repo;

import com.example.demo.model.city;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<city,Integer> {
}
