package com.diplomaticdelivery.diplomatic.responseDto;

import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.requestDto.CommentDTO;
import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.requestDto.LocationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignmentResponse {

    private UUID id;
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
    private List<CommentDTO> comment;
    private List<ConsignmentTrackerResponse> consignmentTracker;

    public static ConsignmentResponse mapResponse(Consignment consigment){

        List<CommentDTO> commentDTOList = consigment.getComment().stream().map((c) -> CommentDTO.mapResponse(c)).collect(Collectors.toList());
        List<ConsignmentTrackerResponse> consignmentTrackerResponseDTOList = consigment.getConsignmentTracker().stream().map((ct) -> ConsignmentTrackerResponse.mapResponse(ct)).collect(Collectors.toList());

        return ConsignmentResponse.builder()
                .id(consigment.getId())
                .branch(consigment.getBranch())
                .branchPhoneNumber(consigment.getBranchPhoneNumber())
                .branchEmail(consigment.getBranchEmail())
                .receiverEmail(consigment.getReceiverEmail())
                .receiverLocation(consigment.getReceiverLocation())
                .receiverName(consigment.getReceiverName())
                .receiverPhoneNumber(consigment.getReceiverPhoneNumber())
                .receiverLocation(consigment.getReceiverLocation())
                .senderLocation(consigment.getSenderLocation())
                .senderName(consigment.getSenderName())
                .senderPhoneNumber(consigment.getSenderPhoneNumber())
                .senderEmail(consigment.getSenderEmail())
                .senderLocation(consigment.getSenderLocation())
                .comment(commentDTOList)
                .weight(consigment.getWeight())
                .typeOfShipment(consigment.getTypeOfShipment())
                .modeOfShipment(consigment.getModeOfShipment())
                .description(consigment.getDescription())
                .consignmentId(consigment.getConsignmentId())
                .invoiceNumber(consigment.getInvoiceNumber())
                .consignmentTracker(consignmentTrackerResponseDTOList)
                .build();
    }
}
