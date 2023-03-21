package com.pfcti.springdata.service;


import com.pfcti.springdata.dto.*;
import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.repository.InversionRepository;
import com.pfcti.springdata.repository.TarjetaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ProductoService {

    private CuentaRepository cuentaRepository;

    private TarjetaRepository tarjetaRepository;

    private InversionRepository inversionRepository;

    public ProductsDto obtieneProductosActivosPorCliente(int clienteId)
    {
        ProductsDto products = new ProductsDto();
/*
        var cuentas = cuentaRepository.findCuentaByClienteIdAndEstadoIsTrue(clienteId);
        var tarjetas = tarjetaRepository.findTarjetaByClienteIdAndEstadoIsTrue(clienteId);
        var inversiones = inversionRepository.findInversionByClienteIdAndEstadoIsTrue(clienteId);

        cuentas.forEach(cuenta -> {
            result.getCuentas().add(fromCuentaToDto(cuenta));
        });
        tarjetas.forEach(tarjeta -> {
            result.getTarjetas().add(fromTarjetaToDto(tarjeta));
        });
        inversiones.forEach(inversion -> {
            result.getInversiones().add(fromInversionToDto(inversion));
        });
  */
        return products;
    }

    public static ClienteDto fromClienteToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }
    public static CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }
    public static InversionDto fromInversionToDto(Inversion inversion){
        InversionDto inversionDto = new InversionDto();
        BeanUtils.copyProperties(inversion, inversionDto);
        return inversionDto;
    }

    public static TarjetaDto fromTarjetaToDto(Tarjeta tarjeta){
        TarjetaDto tarjetaDto = new TarjetaDto();
        BeanUtils.copyProperties(tarjeta, tarjetaDto);
        return tarjetaDto;
    }

}