package com.pfcti.springdata.springwebservices.api;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.service.CuentaService;
import com.pfcti.springdata.springjms.dto.NotificationDto;
import com.pfcti.springdata.springjms.senders.NotificationSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/queque")
@Slf4j
public class QuequeApi {

    @Autowired
    private NotificationSender notificationSender;

    @PostMapping
    public void pointToPoint(@RequestBody CuentaDto cuentaDto){

        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setPhoneNumber("111");
        notificationDto.setMailBody("cuerpo del mensaje");
        notificationSender.sendSMS(notificationDto);
    }
}