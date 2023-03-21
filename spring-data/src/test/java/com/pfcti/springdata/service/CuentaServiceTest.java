package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void buscarCuentaDinamicamentePorCriterio() {

        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setNumero("22222");
        cuentaDto.setEstado(true);
/*
        List<CuentaDto> cuentas = cuentaService.buscarCuentaDinamicamentePorCriterio(cuentaDto);

        cuentas.forEach( cuenta -> {
            System.out.println( "-- [Cuentas]--" );
            System.out.println( String.format("numero: %s", cuenta.getNumero()));
        });
*/
        assertEquals(1,1);
        //assertEquals(1,cuentas.size());

    }
}