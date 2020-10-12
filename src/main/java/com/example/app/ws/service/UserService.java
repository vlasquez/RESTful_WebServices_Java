package com.example.app.ws.service;

import com.example.app.ws.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO user);

    UserDTO getUser(String email);
}
