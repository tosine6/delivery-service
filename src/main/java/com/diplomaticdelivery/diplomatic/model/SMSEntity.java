package com.diplomaticdelivery.diplomatic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sms_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SMSEntity extends BaseEntity{

    private String sender;
    private String message;
    private String receive;
    private String subject;
}
