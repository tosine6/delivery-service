package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.requestDto.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "Register new client")
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDTO signUp) {

        User response = userService.registerUser(signUp);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
