package com.cars.cars.service;

import com.cars.cars.dto.UserDto;
import com.cars.cars.model.User;
import com.cars.cars.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    public UserDto getUserById(Long id) {
        return userRepo.findById(id).map(this::toDto).orElse(null);
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.id = user.getId();
        dto.name = user.getName();
        dto.email = user.getEmail();
        dto.phone = user.getPhone();
        return dto;

    }
}
