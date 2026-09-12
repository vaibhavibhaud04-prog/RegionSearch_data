package com.example.region_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.region_api.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    // Search Only Region
    List<Location> findByRegionIgnoreCase(String region);

    // Search Only Name 
    List<Location> findByNameContainingIgnoreCase(String name);

    // Region + name 
    List<Location> findByRegionIgnoreCaseAndNameContainingIgnoreCase(
            String region,
            String name
    );
}