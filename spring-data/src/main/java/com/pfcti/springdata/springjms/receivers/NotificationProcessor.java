package com.pfcti.springdata.springjms.receivers;

import com.pfcti.springdata.springjms.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//Consumidor de la cola
@Component
@Slf4j
public class NotificationProcessor {
    @JmsListener(destination = "smsReceiverJms")// va a representar el nombre de la cola donde se está escuchando
    public void processMessage(NotificationDto noticationDto){
        // Logica de envio de SMS a twilio.
        log.info("sms info: {}", noticationDto);
    }
}
