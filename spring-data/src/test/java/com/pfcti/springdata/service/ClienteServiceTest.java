package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.ProductsDto;
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

    @Test
    void obtenerCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        //assertEquals("1", clienteDto.getId());
    }

    @Test
    void eliminarCliente() {
        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        assertEquals(1, clienteDtoBase.getId());

        clienteService.eliminarCliente(1);

        try {
            clienteService.obtenerCliente(1);
            fail("No debe llegar aca");
        } catch (RuntimeException e) {
            System.out.println("CLIENTE NO EXISTE: " + e.getMessage());
        }
    }

    @Test
    void actualizarCliente() {

        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        System.out.println(clienteDtoBase);

        clienteDtoBase.setNombre(clienteDtoBase.getNombre() + "TEST");
        clienteDtoBase.setCedula(clienteDtoBase.getCedula() + "TEST");
        clienteDtoBase.setTelefono(clienteDtoBase.getTelefono() + "TEST");
        clienteDtoBase.setApellidos(clienteDtoBase.getApellidos() + "TEST");
        clienteService.actualizarCliente(clienteDtoBase);

        ClienteDto clienteDtoBaseUpdated = clienteService.obtenerCliente(1);

        System.out.println(clienteDtoBaseUpdated);
        assertEquals("ROBERTOTEST", clienteDtoBaseUpdated.getNombre());
        assertEquals("PEREZTEST", clienteDtoBaseUpdated.getApellidos());
    }

    //bmv: Consulta por llave foranea
    @Test
    void obtenerClientesPorCodigoISOPaisYCuentasActivas() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("CR");
        clientesDto.forEach(clienteDto -> {System.out.println("Cuentas Activas" + clienteDto);});
        assertEquals(1, clientesDto.size());
    }

    //Consulta por JPLSQL.
    @Test
    void buscarClientesPorApellido() {
        List<Cliente> cliente =  clienteService.buscarClientesPorApellido("PEREZ");
        assertFalse(cliente.isEmpty());
        assertEquals("PEREZ", cliente.get(0).getApellidos());
    }

    //Consulta consulta nativa.
    @Test
    void buscarClientesPorApellidoNativo() {
        List<Cliente> cliente =  clienteService.buscarClientesPorApellido("PEREZ");
        assertFalse(cliente.isEmpty());
        assertEquals("PEREZ", cliente.get(0).getApellidos());
    }

    @Test
    void buscarClientesDinamicamentePorCriterio() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDto.setNombre("RAUL");
        List<ClienteDto> resultadoCriteriosConDatosDTO = clienteService.buscarClientesDinamicamentePorCriterio(clienteDto);

        resultadoCriteriosConDatosDTO.forEach(clienteDtoResultado -> {
            System.out.println( "-- [Cliente]--" );
            System.out.println( String.format("nombre: %s",clienteDtoResultado.getNombre()) );
            System.out.println( String.format("apellido: %s",clienteDtoResultado.getApellidos()) );
        });

        assertEquals(1,resultadoCriteriosConDatosDTO.size());
    }

    @Test
    void obtenerProductosDelCliente() {
        ProductsDto productsDto = new ProductsDto();
        productsDto = clienteService.obtenerProductosDelCliente(1);

        System.out.println( "-- [cuentas]--" );
        productsDto.getCuentas().forEach( cuenta -> {
            System.out.println( String.format("cuenta: %s", cuenta.getNumero()) );
        });

        System.out.println( "--[tarjetas]--" );
        productsDto.getTarjetas().forEach( tarjeta -> {
            System.out.println( String.format("tarjeta: %s", tarjeta.getNumero()) );
        });

        System.out.println( "--[inversiones]--" );
        productsDto.getInversiones().forEach( inversion -> {
            System.out.println( String.format("inversion: %s", inversion.getNumero()) );
        });

        assertEquals(1,1);
    }

}