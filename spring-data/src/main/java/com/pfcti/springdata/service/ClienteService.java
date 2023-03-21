package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.repository.DireccionRepository;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    private DireccionRepository direccionRepository;
    private CuentaRepository cuentaRepository;

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

}
