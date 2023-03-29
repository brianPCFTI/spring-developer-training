package com.pfcti.springdata.springjms.pubsubs;

import com.pfcti.springdata.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProcesadorNotificacionClientes {

    @ServiceActivator(inputChannel = "pubSubNotification")
    public Message<String> consumirMensajeParaEnvioFormatoEjecutivos(Message<ClienteDto> message){
        ClienteDto clienteDto = message.getPayload();
        log.info("consumirMensajeParaEnvioFormatoEjecutivos");
        // Puede tener la logica que necesitemos
        // Envio SMS con formato a Cliente
        return MessageBuilder.withPayload("Mensaje recibido por ProcesadorNotificacionEjecutivos")
                .build();
    }
}