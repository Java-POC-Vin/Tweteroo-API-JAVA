package com.tweteroo.api.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> save(UserDTO dto) {
        UserModel body = new UserModel(dto);
        boolean userExist = userRepository.existsByUsername(dto.getUsername());

        if (userExist) {
            return Optional.empty();
        }

        return Optional.of(userRepository.save(body));
    }
}
