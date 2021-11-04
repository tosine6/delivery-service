package com.diplomaticdelivery.diplomatic.request;

import com.diplomaticdelivery.diplomatic.model.Location;
import com.diplomaticdelivery.diplomatic.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotNull
    private String name;
    @NotNull
    private String userName;
    private User.Gender gender;
    private String profilePicture;
    @NotNull
    private String emailAddress;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
    private Location location;
    private User.UserType usertype;

}
