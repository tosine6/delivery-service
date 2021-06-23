package com.diplomaticdelivery.diplomatic.repository;


import com.diplomaticdelivery.diplomatic.model.Consignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsignmentRepository extends JpaRepository<Consignment, UUID> {

    Consignment findByConsignmentId(String consignmentId);

}
