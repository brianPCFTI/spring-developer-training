package com.pfcti.springdata.springjms.senders;

import com.pfcti.springdata.springjms.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendSMS(NotificationDto notificationDto){
        log.info("numero {}", notificationDto.getPhoneNumber());
        jmsTemplate.convertAndSend("smsReceiverJms", notificationDto);
    }

}
