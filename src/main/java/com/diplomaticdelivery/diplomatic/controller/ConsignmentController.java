package com.diplomaticdelivery.diplomatic.controller;


import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentDTO;
import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.responseDto.ConsignmentResponse;
import com.diplomaticdelivery.diplomatic.service.ConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/consignment")
public class ConsignmentController {

    @Autowired
    private ConsignmentService consignmentService;

    @PostMapping("/create")
    public ResponseEntity<Consignment> createConsignment(@RequestBody ConsignmentDTO consignmentDTO) {
        Consignment response = consignmentService.create(consignmentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/list-all")
    public ResponseEntity <List<ConsignmentResponse>> getAllConsignment() {
        List<ConsignmentResponse> response = consignmentService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find-consignment/{id}")
    public ResponseEntity <ConsignmentResponse> getConsignment(@PathVariable("id") String id) {
        ConsignmentResponse response = consignmentService.findConsignment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity <ConsignmentResponse> getConsignmentById(@PathVariable("id") UUID id) {
        ConsignmentResponse response = consignmentService.findConsignmentById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/trackers/{id}")
    public ResponseEntity <ConsignmentResponse> getConsignmentTrackers(@PathVariable("id") UUID id) {
        ConsignmentResponse response = consignmentService.findConsignmentById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Consignment> deleteConsignment(@PathVariable("id") UUID id) {
        Consignment response = consignmentService.deleteConsignment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Consignment> updateConsignment(@PathVariable("id") UUID id, @RequestBody ConsignmentDTO consignmentDTO) {
        Consignment response = consignmentService.updateConsignment(id, consignmentDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}