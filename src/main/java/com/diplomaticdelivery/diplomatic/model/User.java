package com.diplomaticdelivery.diplomatic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    public enum Gender { MALE, FEMALE, TRANSGENDER, OTHERS };
    public enum UserType{ADMIN, CLIENT};

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType usertype;

    @Column(name = "profilePicture")
    private String profilePicture;

    @Email
    @Column(name = "emailAddress", unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "userName", unique = true, nullable = false)
    private String userName;
    private String phoneNumber;
    private String ssn;
    private LocalDateTime dateOfBirth;
    private String driversLicence;
    private LocalDateTime lastLogIn;

    @JsonIgnore
    private String password;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Location location;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
