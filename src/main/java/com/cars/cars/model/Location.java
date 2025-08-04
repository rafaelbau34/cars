package com.cars.cars.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Location {
    private Long id;
    private String state;
    private String city;
    private String cp; 

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Usuario user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
}


