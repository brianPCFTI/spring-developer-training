package com.pfcti.springdata.springwebservices.api;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto buscarClienteXml(@PathVariable int id){
        log.info("Busqueda del cliente: {} ", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto buscarClienteXmlJson(@PathVariable int id){
        log.info("Busqueda del cliente: {} ", id);
        return clienteService.obtenerCliente(id);
    }

    //Variables por parametro
    //http://localhost:8080/v1/api/cliente/xml/json/1?parameter=1
    @GetMapping(value = "/parameter", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto buscarPorParametro(@RequestParam int id){
        log.info("Busqueda del cliente: {} ", id);
        return clienteService.obtenerCliente(id);
    }

    @PostMapping
    public void guardarCliente (@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente: {} ", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }

}
