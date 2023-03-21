package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductsDto {

  private List<CuentaDto> cuentas = new ArrayList<>();
  private List<InversionDto> inversiones = new ArrayList<>();;
  private List<TarjetaDto> tarjetas = new ArrayList<>();

}
