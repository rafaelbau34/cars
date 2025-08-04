package com.cars.cars.service.impl;

import com.cars.cars.dto.ImageDto;
import com.cars.cars.model.Car;
import com.cars.cars.model.Image;
import com.cars.cars.repository.CarRepository;
import com.cars.cars.repository.ImageRepository;
import com.cars.cars.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public ImageDto createImage(ImageDto dto) {
        Car car = carRepository.findById(dto.carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Image image = new Image();
        image.setUrl(dto.url);
        image.setCar(car);
        image = imageRepository.save(image);

        return toDto(image);
    }

    @Override
    public List<ImageDto> getAllImages() {
        return imageRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ImageDto getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return toDto(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public ImageDto toDto(Image image) {
        ImageDto dto = new ImageDto();
        dto.id = image.getId();
        dto.url = image.getUrl();
        dto.carId = image.getCar().getId();
        return dto;
    }
}
