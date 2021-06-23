package com.diplomaticdelivery.diplomatic.requestDto;

import com.diplomaticdelivery.diplomatic.model.Location;
import com.diplomaticdelivery.diplomatic.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String name;
    private User.Gender gender;
    private String profilePicture;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private Location location;
}
