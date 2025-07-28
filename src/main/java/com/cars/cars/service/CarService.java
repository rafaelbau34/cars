package com.cars.cars.service;

import com.cars.cars.dto.CarDto;
import com.cars.cars.model.Car;
import com.cars.cars.model.User;
import com.cars.cars.repository.CarRepository;
import com.cars.cars.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepo;
    private final UserRepository userRepo;

    public CarService(CarRepository carRepo, UserRepository userRepo) {
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }

    public List<CarDto> getAllCars() {
        return carRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CarDto addCar(CarDto dto) {
        User user = userRepo.findById(dto.userId).orElseThrow();
        Car car = new Car();
        car.setBrand(dto.brand);
        car.setModel(dto.model);
        car.setYear(dto.year);
        car.setPrice(dto.price);
        car.setKilometers(dto.mileage);
        car.setDescription(dto.description);
        car.setUser(user);
        return toDto(carRepo.save(car));
    }

    private CarDto toDto(Car car) {
        CarDto dto = new CarDto();
        dto.id = car.getId();
        dto.brand = car.getBrand();
        dto.model = car.getModel();
        dto.year = car.getYear();
        dto.price = car.getPrice();
        dto.mileage = car.getKilometers();
        dto.description = car.getDescription();
        dto.userId = car.getUser().getId();
        return dto;
    }
}