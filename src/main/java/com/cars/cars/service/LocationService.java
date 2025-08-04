package com.cars.cars.service;

import com.cars.cars.dto.LocationDto;
import java.util.List;

public interface LocationService {
    LocationDto createLocation(LocationDto dto);
    LocationDto updateLocation(Long id, LocationDto dto);
    void deleteLocation(Long id);
    LocationDto getLocationById(Long id);
    LocationDto getLocationByUserId(Long userId);
    List<LocationDto> getAllLocations();
}
