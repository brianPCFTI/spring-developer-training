package com.pfcti.springdata.service;

import com.pfcti.springdata.criteria.ClienteSpecification;
import com.pfcti.springdata.dto.*;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import com.pfcti.springdata.repository.*;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    private DireccionRepository direccionRepository;
    private CuentaRepository cuentaRepository;

    private TarjetaRepository tarjetaRepository;

    private InversionRepository inversionRepository;

    private ClienteSpecification clienteSpecification;

    public void insertarCliente(ClienteDto clienteDto){
       Cliente cliente = new Cliente();
       cliente.setApellidos(clienteDto.getApellidos());
       cliente.setNombre(clienteDto.getNombre());
       cliente.setCedula(clienteDto.getCedula());
       cliente.setTelefono(clienteDto.getTelefono());
       clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente(int idCliente){
       Cliente cliente = clienteRepository.findById(idCliente)
               .orElseThrow( () -> {throw  new RuntimeException("Cliente no existe");});

       ClienteDto clienteDto = new ClienteDto();
       clienteDto.setId(cliente.getId());
       clienteDto.setApellidos(cliente.getApellidos());
       clienteDto.setNombre(cliente.getNombre());
       clienteDto.setCedula(cliente.getCedula());

       return clienteDto;
    }

    public void actualizarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    /*
    public void eliminarCliente(Integer clienteId){
        clienteRepository.deleteById(clienteId);
    }
    */

    public List<ClienteDto> obtenerClientesPorCodigoISOPaisYCuentasActivas(String codigoISOPais){
        List<ClienteDto> resultadoClientesDto = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(codigoISOPais);
        clientes.forEach(cliente -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(cliente.getId());
            clienteDto.setApellidos(cliente.getApellidos());
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setCedula(cliente.getCedula());
            clienteDto.setPaisNacimiento(cliente.getPaisNacimiento());
            resultadoClientesDto.add(clienteDto);
            System.out.println(clienteDto);
        });
        return resultadoClientesDto;
    }

    //Eliminación en cascada (el orden es manual)
    //Igual que en el relacional, primero los hijos, despues el padre
    public void eliminarCliente(Integer clienteId){
        direccionRepository.deleteAllByCliente_Id(clienteId);
        cuentaRepository.deleteAllByCliente_Id(clienteId);
        clienteRepository.deleteById(clienteId);
    }

    public List<Cliente> buscarClientesPorApellido(String apellidos){
        return clienteRepository.buscarPorApellidos(apellidos);
    }

    public List<ClienteDto> buscarClientesPorApellidoNativo(String apellidos){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Tuple> tuples = clienteRepository.buscarPorApellidosNativo(apellidos);
        tuples.forEach(tuple -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setApellidos((String) tuple.get("apellidos"));
            clienteDto.setNombre((String) tuple.get("nombre"));
            clienteDto.setCedula((String) tuple.get("cedula"));
            clienteDtos.add(clienteDto);
            System.out.println(tuple.get("apellidos"));
        });
        return clienteDtos;
    }

    public List<ClienteDto> buscarClientesDinamicamentePorCriterio(ClienteDto clienteDtoFilter){
        return clienteRepository.findAll(clienteSpecification.buildFilter(clienteDtoFilter))
                .stream().map(this::fromClienteToDto).collect(Collectors.toList());
    }

    //Mapeo de propiedades del Entity al DTO.
    private ClienteDto fromClienteToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public ProductsDto obtenerProductosDelCliente(int clientId){

        ProductsDto productsDto = new ProductsDto();

        //List<Cuenta> cuentas = Collections.<Cuenta>emptyList();
        //List<Tarjeta> tarjetas = Collections.<Tarjeta>emptyList();
        //List<Inversion> inversiones = Collections.<Inversion>emptyList();

        List<Cuenta> cuentas = cuentaRepository.findAllById(Arrays.asList(clientId));
        List<Tarjeta> tarjetas = tarjetaRepository.findAllById(Arrays.asList(clientId));
        List<Inversion> inversiones = inversionRepository.findAllById(Arrays.asList(clientId));

        //Mapeo de entidades
        cuentas.forEach(cuenta -> {
            CuentaDto cuentaDto = new CuentaDto();
            BeanUtils.copyProperties(cuenta, cuentaDto);
            productsDto.getCuentas().add(cuentaDto);
        });

        tarjetas.forEach(tarjeta -> {
            TarjetaDto tarjetaDto = new TarjetaDto();
            BeanUtils.copyProperties(tarjeta, tarjetaDto);
            productsDto.getTarjetas().add(tarjetaDto);
        });

        inversiones.forEach(inversion -> {
            InversionDto inversionDto = new InversionDto();
            BeanUtils.copyProperties(inversion, inversionDto);
            productsDto.getInversiones().add(inversionDto);
        });

        return productsDto;

    }


    public ProductosDto obtenerTodosLosProductosDeUnCliente(int id) {
        ProductosDto productosDto = new ProductosDto();
        List<CuentaDto> cuentaDtos = new ArrayList<>();
        cuentaRepository.findByCliente_IdAndEstadoIsTrue(id).forEach(cuenta -> {
            CuentaDto cuentaDto;
            cuentaDto = fromCuentaToDto(cuenta);
            cuentaDtos.add(cuentaDto);
        });
        productosDto.setCuentaDto(cuentaDtos);

        List<TarjetaDto> tarjetaDtos = new ArrayList<>();
        tarjetaRepository.findByCliente_IdAndEstadoIsTrue(id).forEach(tarjeta -> {
            TarjetaDto tarjetaDto;
            tarjetaDto = fromTarjetaToDto(tarjeta);
            tarjetaDtos.add(tarjetaDto);
        });
        productosDto.setTarjetaDtos(tarjetaDtos);

        List<InversionDto> inversionDtos = new ArrayList<>();
        inversionRepository.findByCliente_IdAndEstadoIsTrue(id).forEach(inversion -> {
            InversionDto inversionDto;
            inversionDto = fromInversionToDto(inversion);
            inversionDtos.add(inversionDto);
        });
        productosDto.setInversionDtos(inversionDtos);
        return productosDto;
    }

    private CuentaDto fromCuentaToDto(Cuenta cuenta) {
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

    private TarjetaDto fromTarjetaToDto(Tarjeta tarjeta) {
        TarjetaDto tarjetaDto = new TarjetaDto();
        BeanUtils.copyProperties(tarjeta, tarjetaDto);
        return tarjetaDto;
    }

    private InversionDto fromInversionToDto(Inversion inversion) {
        InversionDto inversionDto = new InversionDto();
        BeanUtils.copyProperties(inversion, inversionDto);
        return inversionDto;
    }

    public List<ClienteDto> listarTodosLosClientes(){
        List<ClienteDto> clienteDtoList = new ArrayList<>();
        clienteRepository
                .findAll()
                .stream()
                .map(cliente -> {
                    clienteDtoList.add(fromClienteToDto(cliente));
                    return cliente;
                })
                .collect(Collectors.toList());
        return clienteDtoList;
    }

}
