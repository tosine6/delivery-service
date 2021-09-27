package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.requestDto.ConsignmentTrackerDTO;
import com.diplomaticdelivery.diplomatic.requestDto.LocationDTO;
import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.model.ConsignmentTracker;
import com.diplomaticdelivery.diplomatic.repository.ConsignmentRepository;
import com.diplomaticdelivery.diplomatic.repository.ConsignmentTrackerRepository;
import com.diplomaticdelivery.diplomatic.service.ConsignmentTrackerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ConsignmentTrackerServiceImpl implements ConsignmentTrackerService {

    private final static Logger logger = LoggerFactory.getLogger(ConsignmentTrackerServiceImpl.class);

    @Autowired
    private ConsignmentTrackerRepository consignmentTrackerRepo;

    @Autowired
    private ConsignmentRepository consignmentRepo;

    @Override
    public ConsignmentTracker save(ConsignmentTrackerDTO tracker) {
        logger.info("creating tracker by consignment...");
        Consignment consignment = consignmentRepo.findById(tracker.getConsignmentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consignment not found!"));

        ConsignmentTracker tracker1 = new ConsignmentTracker();
        tracker1.setConsignment(consignment);
        tracker1.setDeliveryDate(tracker.getDeliveryDate());
        tracker1.setPresentLocation(LocationDTO.mapRequest(tracker.getPresentLocation()));
        tracker1.setStatus(tracker.getStatus());
        tracker1.setProgressLevel(tracker.getProgressLevel());

        consignmentTrackerRepo.save(tracker1);
        logger.info("tracker creation done...");
        return tracker1;
    }

    @Override
    public ConsignmentTracker update(ConsignmentTrackerDTO request, UUID id) {

        logger.info("updating tracker...");
        ConsignmentTracker consignmentTracker = getById(id);

        if(null != request.getConsignmentId()){
            Consignment consignment = consignmentRepo.findById(request.getConsignmentId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consignment not found!"));
            consignmentTracker.setConsignment(consignment);
        }
        if(null != request.getDeliveryDate()){
            consignmentTracker.setDeliveryDate(request.getDeliveryDate());
        }
        if(null != request.getPresentLocation()){
            consignmentTracker.setPresentLocation((LocationDTO.mapRequest(request.getPresentLocation())));
        }
        if(null != request.getProgressLevel()){
            consignmentTracker.setProgressLevel(request.getProgressLevel());
        }
        if(null != request.getStatus()){
            consignmentTracker.setStatus(request.getStatus());
        }

        consignmentTrackerRepo.saveAndFlush(consignmentTracker);
        logger.info("updating tracker done...");
        return consignmentTracker;
    }

    @Override
    public ConsignmentTracker getById(UUID id) {
        logger.info("fetching by id...");
        return consignmentTrackerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consignment tracker not found!"));

    }

    @Override
    public List<ConsignmentTracker> fetchAll() {
        return consignmentTrackerRepo.findAll();
    }

    @Override
    public List<ConsignmentTracker> fetchConsignmentTrackers(UUID id) {
        logger.info("fetching trackers by consignment...");
        Consignment consignment = consignmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consignment not found!"));

        return consignmentTrackerRepo.findByConsignment(consignment);
    }

    @Override
    public ConsignmentTracker delete(UUID id) {
        ConsignmentTracker consignmentTracker = getById(id);
        consignmentTrackerRepo.delete(consignmentTracker);
        return consignmentTracker;
    }
}
