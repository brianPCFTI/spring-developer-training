package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.springbeans.business.BuscadorClientes;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sistemaExterno")
public class BuscadorClientesSystemaExterno implements BuscadorClientes {
    @Override
    public List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto) {
        System.out.println("BuscadorClientesSystemaExterno");
        return null;
    }
}
