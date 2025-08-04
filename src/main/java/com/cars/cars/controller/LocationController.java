package com.cars.cars.controller;

import com.cars.cars.dto.LocationDto;
import com.cars.cars.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public LocationDto createLocation(@RequestBody LocationDto dto) {
        return locationService.createLocation(dto);
    }

    @PutMapping("/{id}")
    public LocationDto updateLocation(@PathVariable Long id, @RequestBody LocationDto dto) {
        return locationService.updateLocation(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/{id}")
    public LocationDto getLocation(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/user/{userId}")
    public LocationDto getLocationByUserId(@PathVariable Long userId) {
        return locationService.getLocationByUserId(userId);
    }

    @GetMapping
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocations();
    }
}