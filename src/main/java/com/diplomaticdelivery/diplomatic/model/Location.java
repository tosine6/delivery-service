package com.diplomaticdelivery.diplomatic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseEntity{

    private String address;
    private String state;
    private String city;

}
