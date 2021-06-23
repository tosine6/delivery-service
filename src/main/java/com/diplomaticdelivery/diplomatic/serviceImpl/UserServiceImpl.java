package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.requestDto.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.Location;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.UserRepository;
import com.diplomaticdelivery.diplomatic.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public User registerUser(RegisterDTO signUp) {

        Location location = Location.builder()
                .address(signUp.getLocation().getAddress())
                .city(signUp.getLocation().getCity())
                .state(signUp.getLocation().getState())
                .build();

        User newUser = new User();
        newUser.setEmailAddress(signUp.getEmailAddress());
        newUser.setName(signUp.getName());
        newUser.setLocation(location);
        newUser.setPassword(passwordEncoder.encode(signUp.getPassword()));
        newUser.setPhoneNumber(signUp.getPhoneNumber());
        newUser.setProfilePicture(signUp.getProfilePicture());
//        newUser.getGender(signUp.getGender());
        newUser.setUsertype(User.UserType.ADMIN);

        userRepository.save(newUser);

        return newUser;
    }
}
