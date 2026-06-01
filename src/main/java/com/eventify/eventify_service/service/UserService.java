package com.eventify.eventify_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.eventify.eventify_service.dto.UserDTOResponse;
import com.eventify.eventify_service.dto.UserDTORequest;
import com.eventify.eventify_service.model.Role;
import com.eventify.eventify_service.model.User;
import com.eventify.eventify_service.repository.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<UserDTOResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public UserDTOResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User updateUser(String id, UserDTORequest dto) {
        User existingUser = getUserEntityById(id);

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(existingUser);
    }
    private User getUserEntityById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    private UserDTOResponse mapToDTO(User user) {
        UserDTOResponse dto = new UserDTOResponse();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        return dto;
    }

}
