package com.diplomaticdelivery.diplomatic.requestDto;

import com.diplomaticdelivery.diplomatic.enumclass.ConsignmentStatus;
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
public class ConsignmentTrackerDTO {

    private LocalDateTime deliveryDate;
    private LocationDTO presentLocation;
    private String progressLevel;
    private ConsignmentStatus status;
    private UUID consignmentId;

}
