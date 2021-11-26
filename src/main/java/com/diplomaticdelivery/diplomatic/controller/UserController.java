package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.request.LoginRequest;
import com.diplomaticdelivery.diplomatic.request.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.CREATED);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register new client")
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDTO signUp) {
        return new ResponseEntity<>(userService.registerUser(signUp), HttpStatus.CREATED);
    }

    @GetMapping("/list-all")
    @ApiOperation(value = "Get all users")
    public ResponseEntity<Object> fetchAllUsers() {
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

}
