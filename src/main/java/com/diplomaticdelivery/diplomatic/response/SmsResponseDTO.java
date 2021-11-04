package com.diplomaticdelivery.diplomatic.response;

import lombok.Data;

@Data
public class SmsResponseDTO {

    private String sender;
    private String message;
    private String receive;
    private String subject;

}
