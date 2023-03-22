package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.springbeans.business.BuscadorClientes;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BaseDatos")
public class BuscadorClientesBdd implements BuscadorClientes {

    @Autowired
    private ClienteRepository clienteRepository;

   @Override
    public List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto) {
       System.out.println("BuscadorClientesBdd");
       //clienteRepository
        return null;
    }
}
