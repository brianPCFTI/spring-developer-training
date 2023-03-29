package com.pfcti.springdata.springjms.pubsubs;

import com.pfcti.springdata.dto.CuentaDto;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface NotificationPubSubSender {
    @Gateway(replyChannel = "pubSubNotification")
    Message<String> sendNotification(Message<CuentaDto> message);
}
