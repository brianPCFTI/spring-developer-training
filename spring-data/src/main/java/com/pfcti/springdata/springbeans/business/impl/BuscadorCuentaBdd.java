package com.pfcti.springdata.springbeans.business.impl;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.springbeans.business.BuscadorClientes;
import com.pfcti.springdata.springbeans.business.BuscadorCuentas;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import com.pfcti.springdata.springbeans.dto.CuentaQueryDto;
import com.pfcti.springdata.springbeans.dto.CuentaQueryType;
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

        List<Cuenta> cuentas = null;
        if (CuentaQueryType.TIPO.equals(clienteQueryDto.getTipoBusqueda())) {
            cuentas = this.cuentaRepository.findByTipo(clienteQueryDto.getTextoBusqueda());
        } else if (CuentaQueryType.NUMERO.equals(clienteQueryDto.getTipoBusqueda())) {
            cuentas = this.cuentaRepository.findByNumero(clienteQueryDto.getTextoBusqueda());
        }
        return Optional.ofNullable(cuentas).map(cuentasAux -> cuentasAux.stream().map(cuenta -> {
            CuentaDto cuentaDto = new CuentaDto();
            cuentaDto.setCliente(cuenta.getCliente());
            cuentaDto.setNumero(cuenta.getNumero());
            cuentaDto.setId(cuenta.getId());
            cuentaDto.setEstado(cuenta.getEstado());
            cuentaDto.setTipo(cuenta.getTipo());
            return cuentaDto;
        }).collect(Collectors.toList())).orElse(new ArrayList<>());

    }
}
