package com.pfcti.springdata.springbeans.business;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuscadorCuentasTest {
    @Autowired
    private BuscadorCuentas baseDeDatosx;

    @Autowired
    @Qualifier("sistemaExternox")
    private BuscadorCuentas buscadorCuentas;


    @Test
    void obtenerListaClientesDeBaseDeDatos() {
        baseDeDatosx.obtenerListaClientes(null);
    }

    @Test
    void obtenerListaClientesDeSistemaExterno(){
        buscadorCuentas.obtenerListaClientes(null);
    }

}