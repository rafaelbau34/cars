package com.cars.cars.service.impl;

import com.cars.cars.dto.UserDto;
import com.cars.cars.model.Usuario;
import com.cars.cars.repository.UserRepository;
import com.cars.cars.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepo.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        Usuario user = new Usuario();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return toDto(userRepo.save(user));
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        return userRepo.findById(id).map(user -> {
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            return toDto(userRepo.save(user));
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    private UserDto toDto(Usuario user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }
}
