package com.cars.cars.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private int kilometers;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate postedAt = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getBrand() { return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() { return model;}
    public void setModel(String model) {this.model = model;}

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getKilometers() {return kilometers;}
    public void setKilometers(int kilometers) {this.kilometers = kilometers;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public LocalDate getPostedAt() {return postedAt;}
    public void setPostedAt(LocalDate postedAt) {this.postedAt = postedAt;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}