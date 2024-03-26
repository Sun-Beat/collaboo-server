package com.example.collaboo.service;// UserService.java
import com.example.collaboo.domain.User;
import com.example.collaboo.dto.UserDTO;
import com.example.collaboo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setProfile(userDTO.getProfile());

        return userRepository.save(user);
    }
}