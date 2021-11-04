package com.diplomaticdelivery.diplomatic.request;


import com.diplomaticdelivery.diplomatic.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private String address;
    private String state;
    private String city;

    public static Location mapRequest(LocationDTO location){
        return Location.builder()
                .state(location.getState())
                .city(location.getCity())
                .address(location.getAddress())
                .build();
    }
}
