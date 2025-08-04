package com.cars.cars.service;

import com.cars.cars.dto.ImageDto;
import java.util.List;

public interface ImageService {
    ImageDto createImage(ImageDto dto);
    List<ImageDto> getAllImages();
    ImageDto getImageById(Long id);
    void deleteImage(Long id);
}
