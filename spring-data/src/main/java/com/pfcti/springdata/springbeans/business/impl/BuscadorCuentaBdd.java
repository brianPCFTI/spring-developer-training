package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.springbeans.business.BuscadorClientes;
import com.pfcti.springdata.springbeans.business.BuscadorCuentas;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import com.pfcti.springdata.springbeans.dto.CuentaQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("baseDeDatosx")
public class BuscadorCuentaBdd implements BuscadorCuentas {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaDto> obtenerListaClientes(CuentaQueryDto clienteQueryDto) {
        System.out.println("BuscadorCuentaBdd");
     return null;
    }
}
