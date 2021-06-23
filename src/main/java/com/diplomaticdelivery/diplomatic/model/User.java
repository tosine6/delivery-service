package com.diplomaticdelivery.diplomatic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    public enum Gender { MALE, FEMALE, TRANSGENDER };
    public enum UserType{ADMIN, CLIENT};

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "user_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType usertype;

    private String profilePicture;

    @Column(name = "emailAddress", unique = true, nullable = false)
//    @Email
    @NotNull
    private String emailAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Location location;

}
