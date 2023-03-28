package com.pfcti.springdata.springwebservices.api;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cuenta")
@Slf4j
public class CuentaApi {

    @Autowired

    private CuentaService cuentaService;

    @GetMapping(value = "/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<CuentaDto> buscarCuenta(@PathVariable int id){
        log.info("Busqueda de Cuentas; {}", id);
        return cuentaService.buscarCuentasPorCliente(id);
    }

    @PostMapping
    public void guardarCuenta(@RequestBody CuentaDto cuentaDto){
        log.info("Busqueda de Cuenta; {}", cuentaDto);
        cuentaService.creacionDeCuenta(cuentaDto);
    }

    @PutMapping("/{id}")
    public void desactivarCuentasPorCliente_id(@PathVariable Integer id){
        cuentaService.desactivarCuentasPorCliente_id(id);
    }
    
}