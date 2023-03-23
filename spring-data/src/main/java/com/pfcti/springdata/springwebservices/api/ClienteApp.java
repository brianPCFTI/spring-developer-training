package com.pfcti.springdata.springwebservices.api;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/cliente")
@Slf4j
public class ClienteApp {

    @Autowired
    private ClienteService clienteService;

    //Lectura de un recurso del url en este caso el 1
    //http://localhost:8080/v1/api/cliente/1
    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda del cliente: {} ", id);
        return clienteService.obtenerCliente(id);
    }

}
