package com.attractor.service;

import com.attractor.advice.ResourceNotFoundException;
import com.attractor.advice.UserAlreadyRegisteredException;
import com.attractor.dto.RegisUser;
import com.attractor.dto.UserDto;

import com.attractor.model.User;
import com.attractor.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService  {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserDto register(RegisUser form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(form.getEmail())
                .fullname(form.getName())
                .password(encoder.encode(form.getPassword()))
                .role(form.getRole())
                .build();

        repository.save(user);

        return UserDto.from(user);
    }

    public UserDto getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with email = " + email));

        return UserDto.from(user);
    }


}

