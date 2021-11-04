package com.diplomaticdelivery.diplomatic.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignmentDTO {

    private String consignmentId;
    private String branch;
    private String branchEmail;
    private String branchPhoneNumber;
    private String senderEmail;
    private String senderName;
    private String senderPhoneNumber;
    private String receiverEmail;
    private String receiverName;
    private String receiverPhoneNumber;
    private String weight;
    private String quantity;
    private String modeOfShipment;
    private String typeOfShipment;
    private String invoiceNumber;
    private String description;
    private String pickUp;
    private String senderLocation;
    private String receiverLocation;
    private String consignmentComment;
    private LocationDTO consignmentTracker;
    private CommentDTO comment;
    private ConsignmentTrackerDTO consignmentTrackerDTO;

}
