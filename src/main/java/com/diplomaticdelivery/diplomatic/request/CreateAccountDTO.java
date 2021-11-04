package com.diplomaticdelivery.diplomatic.request;

import com.diplomaticdelivery.diplomatic.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {

    @NotNull
    private String name;
    @NotNull
    private String ssn;
    @NotNull
    private String driversLicence;
    @NotNull
    private LocalDate dateOfBirth;
    private Location location;
    private String password;
    @NotNull
    private String emailAddress;
    private String phoneNumber;
}
