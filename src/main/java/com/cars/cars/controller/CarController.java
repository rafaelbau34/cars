package com.cars.cars.controller;

import com.cars.cars.dto.CarDto;
import com.cars.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public CarDto addCar(@RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }
}