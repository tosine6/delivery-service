package com.diplomaticdelivery.diplomatic.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "consignment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consignment extends BaseEntity{

    @NotNull
    @Column(name = "consignmentId", unique = true)
    private String consignmentId;

    @Column(name = "branch")
    private String branch;

    @Column(name = "branchEmail")
    private String branchEmail;

    @Column(name = "branchPhoneNumber")
    private String branchPhoneNumber;

    @Column(name = "senderEmail")
    private String senderEmail;

    @Column(name = "senderName")
    private String senderName;

    @Column(name = "senderPhoneNumber")
    private String senderPhoneNumber;

    @Column(name = "senderLocation")
    private String senderLocation;

    @Column(name = "receiverEmail")
    private String receiverEmail;

    @Column(name = "receiverName")
    private String receiverName;

    @Column(name = "receiverPhoneNumber")
    private String receiverPhoneNumber;

    @Column(name = "receiverLocation")
    private String receiverLocation;

    @Column(name = "weight")
    private String weight;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "modeOfShipment")
    private String modeOfShipment;

    @Column(name = "typeOfShipment")
    private String typeOfShipment;

    @Column(name = "invoiceNumber")
    private String invoiceNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "consignmentComment")
    private String consignmentComment;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Comment> comment;

    @Column(name = "pickUp")
    private String pickUp;

    @JsonIgnore
    @OneToMany(mappedBy = "consignment", cascade = CascadeType.ALL)
    private Collection<ConsignmentTracker> consignmentTracker;
}
