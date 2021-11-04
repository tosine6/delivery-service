package com.diplomaticdelivery.diplomatic.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SmsRequestDTO {

    private String from;
    private String message;
    private String to;
    private String subject;

}
