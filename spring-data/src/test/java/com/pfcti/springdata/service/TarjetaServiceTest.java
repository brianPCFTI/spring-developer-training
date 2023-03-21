package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.TarjetaDto;
import com.pfcti.springdata.model.Tarjeta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TarjetaServiceTest {

    @Autowired
    private TarjetaService tarjetaService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void cambiarEstadoTarjetaPorId() {
        TarjetaDto tarjetaDto = tarjetaService.cambiarEstadoTarjetaPorId(1, false);
        assertEquals(false,tarjetaDto.getEstado());
    }
}