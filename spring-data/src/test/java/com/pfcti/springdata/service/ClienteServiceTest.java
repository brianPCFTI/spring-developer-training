package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Slf4j
class ClienteServiceTest {

    private static Logger log = LoggerFactory.getLogger(ClienteServiceTest.class);

    @Autowired
    private ClienteService clienteService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertarCliente() {

        List<Cliente> clienteList = entityManager.createQuery("Select c from Cliente c").getResultList();
        //log.info(  String.format("listar antes de insertar: %s", clienteList));
        System.out.println( String.format("listar antes de insertar: %s", clienteList));

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("Salazar");
        clienteDto.setNombre("Alberto");
        clienteDto.setCedula("1890000000");
        clienteDto.setTelefono("0999714563");

        clienteService.insertarCliente(clienteDto);

        clienteList = entityManager.createQuery("Select c from Cliente c").getResultList();
        assertFalse(clienteList.isEmpty());
        System.out.println( String.format("listar antes de insertar: %s", clienteList));
        //assertEquals("Salazar", clienteList.get(5).getNombre());


    }
}