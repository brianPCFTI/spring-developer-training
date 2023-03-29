package com.pfcti.springdata.springwebservices.api;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.service.CuentaService;
import com.pfcti.springdata.springjms.dto.NotificationDto;
import com.pfcti.springdata.springjms.pubsubs.NotificationPubSubSender;
import com.pfcti.springdata.springjms.senders.NotificationSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.List;

@RestController
@RequestMapping("/v1/api/queque")
@Slf4j
public class QuequeApi {

    @Autowired
    private NotificationSender notificationSender;

    @Autowired
    NotificationPubSubSender notificationPubSubSender;

    @PostMapping
    public void pointToPoint(@RequestBody CuentaDto cuentaDto){

        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setPhoneNumber("111");
        notificationDto.setMailBody("cuerpo del mensaje");
        notificationSender.sendSMS(notificationDto);
    }

    @PostMapping(value = "/publishSubscribe")
    public void publishSubscribe(@RequestBody CuentaDto cuentaDto){
        Message<CuentaDto> message = MessageBuilder.withPayload(cuentaDto).build();
        notificationPubSubSender.sendNotification(message);
    }

}

/*

Llamada a Twilio.

private final static String TWILIO_ACCOUNT_SID = "";
    private final static String TWILIO_AUTH_TOKEN = "";
    private final static String TWILIO_MESSAGE_SID = "";
// Puede tener la logica que necesitemos
        String sms = "Hola desde Twilio SMS";
        Twilio.init(TWILIO_ACCOUNT_SID.trim(), TWILIO_AUTH_TOKEN.trim());
        com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+593999714503"),
                TWILIO_MESSAGE_SID.trim(), sms).create();

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

* */