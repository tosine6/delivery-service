package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.request.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;

import java.util.List;
import java.util.UUID;

public interface ConsignmentTrackerService {

    ConsignmentTracker save(ConsignmentTrackerDTO tracker);
    ConsignmentTracker update(ConsignmentTrackerDTO tracker, UUID id);
    ConsignmentTracker getById(UUID id);
    List<ConsignmentTracker> fetchAll();
    List<ConsignmentTracker> fetchConsignmentTrackers(UUID id);
    ConsignmentTracker delete(UUID id);

}
