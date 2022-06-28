package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserService {

    private final userRepository UserRepository;

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public User updateUser(User user) {
        return create(user);
    }

    public void delete(Long userId) {
        UserRepository.deleteById(String.valueOf(userId));
    }

    public User getUser(Long userId) {
        return UserRepository.getById(String.valueOf(userId));
    }

    public User create(User user) {
        return UserRepository.save(user);
    }

}
