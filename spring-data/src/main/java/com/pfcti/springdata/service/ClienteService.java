package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    ClienteRepository clienteRepository;

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
    public void eliminarCliente(Integer clienteId){
        clienteRepository.deleteById(clienteId);
    }


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


}
