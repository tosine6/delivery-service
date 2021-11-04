package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.request.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User registerUser(RegisterDTO signUp);
    List<User>fetchAllUsers();
}
