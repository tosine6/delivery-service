package com.diplomaticdelivery.diplomatic.repository;

import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConsignmentTrackerRepository extends JpaRepository<ConsignmentTracker, UUID> {

    List<ConsignmentTracker> findByConsignment(Consignment consignment);
}
