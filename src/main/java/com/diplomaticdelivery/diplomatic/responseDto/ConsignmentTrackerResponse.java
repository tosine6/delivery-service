package com.diplomaticdelivery.diplomatic.responseDto;

import com.diplomaticdelivery.diplomatic.enumclass.ConsignmentStatus;
import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.requestDto.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsignmentTrackerResponse {
    private UUID id;
    private LocalDateTime deliveryDate;
    private LocationResponse presentLocation;
    private String progressLevel;
    private ConsignmentStatus status;

    public static ConsignmentTrackerResponse mapResponse(ConsignmentTracker tracker){

        LocationResponse location= LocationResponse.mapResponse(tracker.getPresentLocation());

        return ConsignmentTrackerResponse.builder()
                .id(tracker.getId())
                .presentLocation(location)
                .deliveryDate(tracker.getDeliveryDate())
                .progressLevel(tracker.getProgressLevel())
                .status(tracker.getStatus())
                .build();
    }

}
