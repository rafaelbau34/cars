package com.cars.cars.service.impl;

import com.cars.cars.dto.CarDto;
import com.cars.cars.model.Car;
import com.cars.cars.model.Usuario;
import com.cars.cars.repository.CarRepository;
import com.cars.cars.repository.UserRepository;
import com.cars.cars.service.CarService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepo;
    private final UserRepository userRepo;

    public CarServiceImpl(CarRepository carRepo, UserRepository userRepo) {
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CarDto addCar(CarDto dto) {
        Usuario user = userRepo.findById(dto.getUserId()).orElseThrow();
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setPrice(dto.getPrice());
        car.setKilometers(dto.getKilometers());
        car.setDescription(dto.getDescription());
        car.setUser(user);
        return toDto(carRepo.save(car));
    }

    @Override
    public CarDto updateCar(Long id, CarDto dto) {
        return carRepo.findById(id).map(car -> {
            car.setBrand(dto.getBrand());
            car.setModel(dto.getModel());
            car.setYear(dto.getYear());
            car.setPrice(dto.getPrice());
            car.setKilometers(dto.getKilometers());
            car.setDescription(dto.getDescription());
            if (dto.getUserId() != null) {
                car.setUser(userRepo.findById(dto.getUserId()).orElseThrow());
            }
            return toDto(carRepo.save(car));
        }).orElse(null);
    }

    @Override
    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }

    private CarDto toDto(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setYear(car.getYear());
        dto.setPrice(car.getPrice()) ;
        dto.setKilometers(car.getKilometers());
        dto.setDescription(car.getDescription());
        dto.setUserId(car.getUser().getId());
        return dto;
    }
}
