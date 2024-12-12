package com.coderscampus.assignment14.service;


import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.getUser(id);
    }

    public User registerOrGetUser(String name) {
        User existingUser = userRepository.findByName(name);
        if (existingUser != null) {
            return existingUser;
        }

        User newUser = new User(name, System.currentTimeMillis());
        userRepository.addUser(newUser);
        return newUser;
    }

    public boolean userExists(Long id) {
        return userRepository.userExists(id);
    }
}



