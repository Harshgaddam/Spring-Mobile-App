package com.mobileapp.mobileapp.ui.controller;

import com.mobileapp.mobileapp.service.UserService;
import com.mobileapp.mobileapp.shared.dto.UserDto;
import com.mobileapp.mobileapp.ui.model.response.UserRest;
import com.mobileapp.mobileapp.ui.model.request.UserDetailsRequestModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService UserService;

    @GetMapping
    public String getUser() {
        return "getUser was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = UserService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }
}
