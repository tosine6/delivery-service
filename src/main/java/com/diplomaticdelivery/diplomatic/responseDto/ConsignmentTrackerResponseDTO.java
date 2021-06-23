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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsignmentTrackerResponseDTO {
    private LocalDateTime deliveryDate;
    private LocationResponseDTO presentLocation;
    private String progressLevel;
    private ConsignmentStatus status;

    public static ConsignmentTrackerResponseDTO mapResponse(ConsignmentTracker tracker){

        LocationResponseDTO location= LocationResponseDTO.mapResponse(tracker.getPresentLocation());

        return ConsignmentTrackerResponseDTO.builder()
                .presentLocation(location)
                .deliveryDate(tracker.getDeliveryDate())
                .progressLevel(tracker.getProgressLevel())
                .status(tracker.getStatus())
                .build();
    }

}
