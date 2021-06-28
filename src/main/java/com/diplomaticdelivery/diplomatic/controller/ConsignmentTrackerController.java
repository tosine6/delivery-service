package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import com.diplomaticdelivery.diplomatic.service.ConsignmentTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/consignment-tracker")
public class ConsignmentTrackerController {

    @Autowired
    private ConsignmentTrackerService consignmentTrackerService;

    @PostMapping("/create")
    public ResponseEntity<ConsignmentTracker> createConsignmentTracker(@RequestBody ConsignmentTrackerDTO request) {
        ConsignmentTracker response = consignmentTrackerService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/list-all")
    public ResponseEntity <List<ConsignmentTracker>> getAllConsignmentTracker() {
        List<ConsignmentTracker> response = consignmentTrackerService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetch-by-consignment/{id}")
    public ResponseEntity <List<ConsignmentTracker>> getAllForAConsignment(@PathVariable("id") UUID id) {
        List<ConsignmentTracker> response = consignmentTrackerService.fetchConsignmentTrackers(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetch-by-id/{id}")
    public ResponseEntity <ConsignmentTracker> getTrackerById(@PathVariable("id") UUID id) {
        ConsignmentTracker response = consignmentTrackerService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <ConsignmentTracker> updateConsignmentTracker(@PathVariable("id") UUID id, @RequestBody ConsignmentTrackerDTO request) {
        ConsignmentTracker response = consignmentTrackerService.update(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
