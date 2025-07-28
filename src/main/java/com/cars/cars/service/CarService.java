package com.cars.cars.service;

import com.cars.cars.dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();
    CarDto addCar(CarDto dto);
    CarDto updateCar(Long id, CarDto dto);
    void deleteCar(Long id);
}
