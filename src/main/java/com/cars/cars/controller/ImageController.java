package com.cars.cars.controller;

import com.cars.cars.dto.ImageDto;
import com.cars.cars.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ImageDto create(@RequestBody ImageDto dto) {
        return imageService.createImage(dto);
    }

    @GetMapping
    public List<ImageDto> getAll() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ImageDto getById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
