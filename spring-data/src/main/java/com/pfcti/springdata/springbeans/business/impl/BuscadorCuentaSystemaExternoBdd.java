package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.springbeans.business.BuscadorCuentas;
import com.pfcti.springdata.springbeans.dto.CuentaQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sistemaExternox")
public class BuscadorCuentaSystemaExternoBdd implements BuscadorCuentas {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaDto> obtenerListaClientes(CuentaQueryDto clienteQueryDto) {
        System.out.println("BuscadorCuentaSystemaExternoBdd");
     return null;
    }
}
