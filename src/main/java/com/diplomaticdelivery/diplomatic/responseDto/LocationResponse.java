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
public class LocationResponse {

    private String address;
    private String state;
    private String city;

    public static LocationResponse mapResponse(Location location){

        return LocationResponse.builder()
                .address(location.getAddress())
                .state(location.getState())
                .city(location.getCity())
                .build();
    }
}
