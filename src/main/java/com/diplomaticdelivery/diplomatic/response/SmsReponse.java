package com.diplomaticdelivery.diplomatic.response;

import lombok.Data;

@Data
public class SmsReponse {

    private String message;
    private SmsResponseDTO data;
}
