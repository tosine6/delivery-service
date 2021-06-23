package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentDTO;
import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.responseDto.ConsignmentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ConsignmentService {

    Consignment create(ConsignmentDTO consignmentDTO);
    List<ConsignmentResponseDTO> fetchAll();
    Consignment deleteConsignment(UUID id);
    Consignment findConsignment(String id);
    Consignment updateConsignment(UUID id, ConsignmentDTO request);
    ConsignmentResponseDTO findConsignmentById(UUID id);

}
