package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.http.HttpService;
import com.diplomaticdelivery.diplomatic.model.SMSEntity;
import com.diplomaticdelivery.diplomatic.repository.SMSRepository;
import com.diplomaticdelivery.diplomatic.request.SmsRequestDTO;
import com.diplomaticdelivery.diplomatic.response.SmsReponse;
import com.diplomaticdelivery.diplomatic.response.SmsResponseDTO;
import com.diplomaticdelivery.diplomatic.service.SMSService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class SMSServiceImpl implements SMSService {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private SMSRepository smsRepository;
    private final HttpService service = new HttpService();

    @Override
    public SmsReponse sendSms(SmsRequestDTO request){
        SmsReponse smsReponse = new SmsReponse();
        Response httpResponse;
        String response;
        try{
            httpResponse = service.post(request.toString());
            response = httpResponse.body().string();
            smsReponse.setMessage(response);
        }catch (Exception e){
            System.out.println("exception msg"+ e.getMessage());
            smsReponse.setMessage(e.getMessage());
        }
        SmsResponseDTO smsResponseDTO = modelMapper.map(request, SmsResponseDTO.class);
        SMSEntity sms = modelMapper.map(smsResponseDTO, SMSEntity.class);
        smsResponseDTO.setSender(request.getFrom());
        smsResponseDTO.setReceive(request.getTo());
        smsReponse.setData(smsResponseDTO);
        smsRepository.save(sms);
        return smsReponse;
    }
}
