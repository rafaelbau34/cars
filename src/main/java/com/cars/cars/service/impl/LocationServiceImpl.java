package com.cars.cars.service.impl;

import com.cars.cars.dto.LocationDto;
import com.cars.cars.model.Location;
import com.cars.cars.model.Usuario;
import com.cars.cars.repository.LocationRepository;
import com.cars.cars.repository.UserRepository;
import com.cars.cars.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public LocationServiceImpl(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LocationDto createLocation(LocationDto dto) {
        Usuario user = userRepository.findById(dto.userId)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));

        Location location = new Location();
        location.setState(dto.state);
        location.setCity(dto.city);
        location.setCp(dto.cp);
        location.setUser(user);

        return toDto(locationRepository.save(location));
    }

    @Override
    public LocationDto updateLocation(Long id, LocationDto dto) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        location.setState(dto.state);
        location.setCity(dto.city);
        location.setCp(dto.cp);

        return toDto(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public LocationDto getLocationById(Long id) {
        return locationRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public LocationDto getLocationByUserId(Long userId) {
        return locationRepository.findByUserId(userId)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Location not found for this user"));
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private LocationDto toDto(Location location) {
        LocationDto dto = new LocationDto();
        dto.id = location.getId();
        dto.state = location.getState();
        dto.city = location.getCity();
        dto.cp = location.getCp();
        dto.userId = location.getUser().getId();
        return dto;
    }
}
