package com.example.hw31.service;

import com.example.hw31.dto.UserDto;
import com.example.hw31.model.User;
import com.example.hw31.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Ludmila Litvinova on 11.02.23
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public void createUser(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        userDto.setId(user.getId());
    }

    public boolean hasUserByName(String name) {
        return userRepository.existsUserByName(name);
    }

}
