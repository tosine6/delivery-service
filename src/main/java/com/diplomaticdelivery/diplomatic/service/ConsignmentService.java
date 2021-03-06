package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.request.ConsignmentDTO;
import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.response.ConsignmentResponse;

import java.util.List;
import java.util.UUID;

public interface ConsignmentService {

    Consignment create(ConsignmentDTO consignmentDTO);
    List<ConsignmentResponse> fetchAll();
    Consignment deleteConsignment(UUID id);
    ConsignmentResponse findConsignment(String id);
    Consignment updateConsignment(UUID id, ConsignmentDTO request);
    ConsignmentResponse findConsignmentById(UUID id);

}
