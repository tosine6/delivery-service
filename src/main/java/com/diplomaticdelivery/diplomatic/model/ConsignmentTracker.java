package com.diplomaticdelivery.diplomatic.model;

import com.diplomaticdelivery.diplomatic.enums.ConsignmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consignment_tracker")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignmentTracker extends BaseEntity{

    @Column(name = "deliveryDate")
    private LocalDateTime deliveryDate;

    @OneToOne(cascade = {CascadeType.ALL})
    private Location presentLocation;

    @Column(name = "progressLevel")
    private String progressLevel;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ConsignmentStatus status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "consignment_id")
    private Consignment consignment;

}
