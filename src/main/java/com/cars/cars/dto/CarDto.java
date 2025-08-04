package com.cars.cars.dto;

import java.util.List;

public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private int kilometers;
    private String description;
    private Long userId;
    private List<ImageDto> images; 

    public CarDto() {}

    public CarDto(Long id, String brand, String model, int year, double price, int kilometers, String description, Long userId, List<ImageDto> images) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.kilometers = kilometers;
        this.description = description;
        this.userId = userId;
        this.images = images;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getKilometers() { return kilometers; }
    public void setKilometers(int kilometers) { this.kilometers = kilometers; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<ImageDto> getImages() { return images; }
    public void setImages(List<ImageDto> images) { this.images = images; }
}
