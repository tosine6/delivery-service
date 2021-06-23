package com.diplomaticdelivery.diplomatic.responseDto;

import com.diplomaticdelivery.diplomatic.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDTO {

    private String address;
    private String state;
    private String city;

    public static LocationResponseDTO mapResponse(Location location){

        return LocationResponseDTO.builder()
                .address(location.getAddress())
                .state(location.getState())
                .city(location.getCity())
                .build();
    }
}
