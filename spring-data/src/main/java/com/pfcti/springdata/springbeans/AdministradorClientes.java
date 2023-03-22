package com.pfcti.springdata.springbeans;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;

import java.util.List;

public class AdministradorClientes {

    private ClienteRepository clienteRepository;

    public AdministradorClientes(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDto> obtenerListaClientesPorCriterio(ClienteQueryDto clienteQueryDto) {
        return null;
    }

}
