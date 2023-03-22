package com.pfcti.springdata.springbeans;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.service.ClienteService;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdministradorClientesConAutWireNamedTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    //Ejemplo de inyección con Autowire con Config vease el nombre de la declaracion del objeto por el alias.
    @Autowired
    private AdministradorClientes defaultCedula;

    //Lo mismo que el anterior defaultCedula, pero con qualified
    @Autowired
    @Qualifier("defaultCedula")
    private AdministradorClientes administrador;

    @BeforeEach
    public void setUp() {
        this.setupClientes();
    }

    //Poblar los datos en memoria, antes de ejecutar las pruebas.
    private void setupClientes() {
        List<ClienteDto> clienteDtos = List.of(
                new ClienteDto(1, "Alberto", "Salazar", "1890000000", "0999714563", "CR", null),
                new ClienteDto(2, "Rosa", "Salazar", "1890000001", "0983475616", "CR", null),
                new ClienteDto(3, "Alexis", "Vivanco", "1890000002", "0983475616", "CR", null),
                new ClienteDto(4, "Natalie", "Vivanco", "1890000003", "0983665616", "CR", null),
                new ClienteDto(5, "Ximena", "Silva", "1890000004", "0983475616", "CR", null),
                new ClienteDto(6, "Thalia", "Rodriguez", "1890000005", "0983475616", "CR", null),
                new ClienteDto(7, "Jonh", "Rodriguez", "1890000006", "0983475616", "CR", null),
                new ClienteDto(8, "Eduardo", "Guerra", "1890000007", "0983475616", "CR", null),
                new ClienteDto(9, "Juan", "Vaca", "1890000008", "0983475616", "CR", null),
                new ClienteDto(10, "Cristina", "Ortiz", "1890000009", "0983475616", "CR", null)
        );
        clienteDtos.forEach(clienteDto -> this.clienteService.insertarCliente(clienteDto));
    }

    @Test
    void obtenerListaClientesPorCriterioCedula() {

        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        clienteQueryDto.setTextoBusqueda("1890000002");
        //Se invoca al método respectivo
        List<ClienteDto> clienteDtos = defaultCedula.obtenerListaClientesPorCriterio(clienteQueryDto);
        Assertions.assertEquals(1, clienteDtos.size());


    }

}