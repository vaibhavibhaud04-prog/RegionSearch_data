package com.example.region_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.region_api.entity.Location;
import com.example.region_api.repository.LocationRepository;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Location> getLocations(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String name) {

       
        if (region != null && !region.isBlank()
                && name != null && !name.isBlank()) {

            return repository.findByRegionIgnoreCaseAndNameContainingIgnoreCase(
                    region, name);
        }

       
        if (region != null && !region.isBlank()) {
            return repository.findByRegionIgnoreCase(region);
        }

       
        if (name != null && !name.isBlank()) {
            return repository.findByNameContainingIgnoreCase(name);
        }

       
        return repository.findAll();
    }
}