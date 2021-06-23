package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.requestDto.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(RegisterDTO signUp);
}
