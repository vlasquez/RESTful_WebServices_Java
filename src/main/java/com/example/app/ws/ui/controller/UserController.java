package com.example.app.ws.ui.controller;

import com.example.app.ws.service.UserService;
import com.example.app.ws.shared.dto.UserDTO;
import com.example.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(userDetails, userDto);
        /*
         * ModelMapper modelMapper = new ModelMapper(); UserDto userDto =
         * modelMapper.map(userDetails, UserDto.class);
         */

        UserDTO createdUser = userService.createUser(userDto);
        // returnValue = modelMapper.map(createdUser, UserRest.class)
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
