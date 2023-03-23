package com.pfcti.springdata.springbeans.business;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.CuentaQueryDto;

import java.util.List;

public interface BuscadorCuentas {
    List<CuentaDto> obtenerListaClientes (CuentaQueryDto cuentaQueryDto);

}
