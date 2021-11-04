package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.enums.RoleType;
import com.diplomaticdelivery.diplomatic.model.Role;
import com.diplomaticdelivery.diplomatic.repository.RoleRepository;
import com.diplomaticdelivery.diplomatic.request.RegisterDTO;
import com.diplomaticdelivery.diplomatic.model.Location;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.UserRepository;
import com.diplomaticdelivery.diplomatic.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    @Override
    @Transactional
    public User registerUser(RegisterDTO signUp) {
        Location location = null;
        if (null != signUp.getLocation()) {
            location = Location.builder().address(signUp.getLocation().getAddress()).city(signUp.getLocation().getCity())
                    .state(signUp.getLocation().getState()).build();
        }
        User newUser = new User();
        Role role = roleRepository.findRoleByName(RoleType.ROLE_USER.getName());
        newUser.setRoles(Arrays.asList(role));

        newUser.setEmailAddress(signUp.getEmailAddress());
        newUser.setName(signUp.getName());
        newUser.setLocation(location);
        newUser.setPassword(passwordEncoder.encode(signUp.getPassword()));
        newUser.setPhoneNumber(signUp.getPhoneNumber());
        newUser.setProfilePicture(signUp.getProfilePicture());
        newUser.setGender(signUp.getGender());
        newUser.setUsertype(User.UserType.CLIENT);
        newUser.setUserName(signUp.getUserName());
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }
}
