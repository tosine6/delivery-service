package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.request.SmsRequestDTO;
import com.diplomaticdelivery.diplomatic.response.SmsReponse;

public interface SMSService {
    SmsReponse sendSms(SmsRequestDTO request);
}
