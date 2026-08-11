package com.mobileapp.mobileapp.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser() {
        return "getUser was called";
    }

    @PostMapping
    public String createUser(@RequestBody userDetailsRequestModel userDetails) {
        return "createUser was called";
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
