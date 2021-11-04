package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.request.CommentDTO;
import com.diplomaticdelivery.diplomatic.request.ConsignmentDTO;
import com.diplomaticdelivery.diplomatic.model.Comment;
import com.diplomaticdelivery.diplomatic.model.Consignment;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.ConsignmentRepository;
import com.diplomaticdelivery.diplomatic.response.ConsignmentResponse;
import com.diplomaticdelivery.diplomatic.service.ConsignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsignmentServiceImpl implements ConsignmentService {

    Logger logger = LoggerFactory.getLogger(ConsignmentServiceImpl.class);

    @Autowired
    private ConsignmentRepository consignmentRepository;

    @Override
    public Consignment create(ConsignmentDTO consignmentDTO) {
        User user = new User();
        logger.info("Creating new consignment...");
        Consignment consignment = new Consignment();
        consignment.setConsignmentId(generateConsignmentId());
        consignment.setBranch(consignmentDTO.getBranch());
        if(null != consignmentDTO.getComment()){
            Comment comment = CommentDTO.map(consignmentDTO.getComment(),user );
            consignment.getComment().add(comment);
        }
        consignment.setBranchEmail(consignmentDTO.getBranchEmail());
        consignment.setDescription(consignmentDTO.getDescription());
        consignment.setBranchPhoneNumber(consignmentDTO.getBranchPhoneNumber());
        consignment.setInvoiceNumber(consignmentDTO.getInvoiceNumber());
        consignment.setModeOfShipment(consignmentDTO.getModeOfShipment());
        consignment.setTypeOfShipment(consignmentDTO.getTypeOfShipment());
        consignment.setPickUp(consignmentDTO.getPickUp());

        consignment.setReceiverEmail(consignmentDTO.getReceiverEmail());
        consignment.setReceiverName(consignmentDTO.getReceiverName());
        consignment.setReceiverPhoneNumber(consignmentDTO.getReceiverPhoneNumber());

        consignment.setSenderEmail(consignmentDTO.getSenderEmail());
        consignment.setSenderName(consignmentDTO.getSenderName());
        consignment.setSenderPhoneNumber(consignmentDTO.getSenderPhoneNumber());
        consignment.setSenderLocation(consignmentDTO.getSenderLocation());
        consignment.setReceiverLocation(consignmentDTO.getReceiverLocation());
        consignment.setConsignmentComment(consignmentDTO.getConsignmentComment());
        consignment.setQuantity(consignmentDTO.getQuantity());
        consignment.setWeight(consignmentDTO.getWeight());
        consignment.setConsignmentComment(consignmentDTO.getConsignmentComment());
        consignmentRepository.save(consignment);
        logger.info("Consignment created...");
        return consignment;
    }

    @Override
    public List<ConsignmentResponse> fetchAll() {
        logger.info("Fetching all created consignments...");
        return consignmentRepository.findAll().stream().map((c) -> ConsignmentResponse.mapResponse(c)).collect(Collectors.toList());
    }

    @Override
    public Consignment deleteConsignment(UUID id) {

        Consignment consignment = consignmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "consignment not found!"));
        consignmentRepository.delete(consignment);
        return consignment;
    }

    @Override
    public ConsignmentResponse findConsignment(String id) {
        Consignment consignment = consignmentRepository.findByConsignmentId(id);
        if(null == consignment)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "consignment not found!");

        return ConsignmentResponse.mapResponse(consignment);
    }

    @Override
    public ConsignmentResponse findConsignmentById(UUID id) {
        logger.info("Fetching consignment by id ..."+ id);
        Optional<Consignment> consignment2 = consignmentRepository.findById(id);
        logger.info("consignment2 ", consignment2.get().getQuantity());

        Consignment consignment = consignmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "consignment not found!"));
        return ConsignmentResponse.mapResponse(consignment);
    }

    @Override
    public Consignment updateConsignment(UUID id, ConsignmentDTO request) {
        logger.info("updating consignment by id ..."+id);

        Consignment consignment = consignmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "consignment not found!"));

        if(null != request.getConsignmentId()){
            consignment.setConsignmentId(request.getConsignmentId());
        }
        if(null != request.getReceiverEmail()){
            consignment.setReceiverEmail(request.getReceiverEmail());
        }
        if(null != request.getReceiverName()){
            consignment.setReceiverName(request.getReceiverName());
        }
        if(null != request.getReceiverLocation()){
            consignment.setReceiverLocation(request.getReceiverLocation());
        }
        if(null != request.getBranch()){
            consignment.setBranch(request.getBranch());
        }
        if(null != request.getBranchPhoneNumber()){
            consignment.setBranchPhoneNumber(request.getBranchPhoneNumber());
        }
        if(null != request.getBranchEmail()){
            consignment.setBranchEmail(request.getBranchEmail());
        }
        if(null != request.getDescription()){
            consignment.setDescription(request.getDescription());
        }
        if(null != request.getInvoiceNumber()){
            consignment.setInvoiceNumber(request.getInvoiceNumber());
        }
        if(null != request.getModeOfShipment()){
            consignment.setModeOfShipment(request.getModeOfShipment());
        }
        if(null != request.getQuantity()){
            consignment.setQuantity(request.getQuantity());
        }
        if(null != request.getPickUp()){
            consignment.setPickUp(request.getPickUp());
        }
        if(null != request.getWeight()){
            consignment.setWeight(request.getWeight());
        }
        if(null != request.getDescription()){
            consignment.setDescription(request.getDescription());
        }
        if(null != request.getSenderName()){
            consignment.setSenderName(request.getSenderName());
        }
        if(null != request.getSenderEmail()){
            consignment.setSenderEmail(request.getSenderEmail());
        }
        if(null != request.getSenderPhoneNumber()){
            consignment.setSenderPhoneNumber(request.getSenderPhoneNumber());
        }
        if(null != request.getSenderLocation()){
            consignment.setSenderLocation(request.getSenderLocation());
        }
        if(null != request.getConsignmentComment()){
            consignment.setConsignmentComment(request.getConsignmentComment());
        }
        consignmentRepository.saveAndFlush(consignment);
        logger.info("done updating consignment by id ...");
        return consignment;
    }

    public String generateConsignmentId(){
        long number = (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);

        return String.valueOf(number);
    }
}
