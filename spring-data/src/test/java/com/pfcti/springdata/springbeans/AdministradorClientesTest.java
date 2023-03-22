package com.pfcti.springdata.springbeans;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdministradorClientesTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    void obtenerListaClientesPorCriterio() {
        //Se instancia la clase, se pasa los elementos dependientes al constructor
        AdministradorClientes administradorClientes = new AdministradorClientes(clienteRepository);
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        clienteQueryDto.setTextoBusqueda("1890000002");
        //Se invoca al método respectivo
        List<ClienteDto> clienteDtos = administradorClientes.obtenerListaClientesPorCriterio(clienteQueryDto);
    }

}