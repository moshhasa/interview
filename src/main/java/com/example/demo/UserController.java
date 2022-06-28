package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<?> getAllNonDuplicateUsers() {
        // Duplicate is when users have the same first name, last name and age
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getNumberOfUsersOfGender(String gender) {
        //use stream to count gender
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/createUsers")
    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/updateUser")
    public ResponseEntity<User> updateUser(User user) {
        final User existingUser = userService.getUser(user.getUserId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setGender(user.getGender());
        return ResponseEntity.ok(userService.updateUser(user));
    }


    @GetMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok(new User());
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

}
