package com.diplomaticdelivery.diplomatic.repository;

import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsignmentTrackerRepository extends JpaRepository<ConsignmentTracker, UUID> {

}
