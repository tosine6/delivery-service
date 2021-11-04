package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import com.diplomaticdelivery.diplomatic.request.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.request.SmsRequestDTO;
import com.diplomaticdelivery.diplomatic.response.SmsReponse;
import com.diplomaticdelivery.diplomatic.response.SmsResponseDTO;
import com.diplomaticdelivery.diplomatic.service.ConsignmentTrackerService;
import com.diplomaticdelivery.diplomatic.service.SMSService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/sms")
public class SmsController {

    private SMSService smsService;

    @PostMapping("/send-sms")
    public ResponseEntity<SmsReponse> sendSms(@RequestBody SmsRequestDTO request) {
        SmsReponse response = smsService.sendSms(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
