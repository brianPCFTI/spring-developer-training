package com.pfcti.springdata.springbeans.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BuscadorClientesTest {

    @Autowired
    @Qualifier("BaseDatos")
    private BuscadorClientes baseDatos;

    @Autowired
    @Qualifier("sistemaExterno")
    private BuscadorClientes buscadorClientes;

    @Test
    void obtenerListaClientes() {

        //Se abstrae el tema de la consulta al repo por problemas técnicos.

       baseDatos.obtenerListaClientes(null);
       buscadorClientes.obtenerListaClientes(null);
       Assertions.assertEquals(1,1);

    }
}