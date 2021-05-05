package com.example.demo.repository;

import com.example.demo.model.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplianceRepository  extends JpaRepository<ApplianceEntity,Integer> {
    @Query("SELECT details FROM ApplianceEntity details WHERE details.brand=?1")
    List<ApplianceEntity> findByApplianceName(String name);
    @Query
    ApplianceEntity deleteBySerialnumber(Integer id);



}
