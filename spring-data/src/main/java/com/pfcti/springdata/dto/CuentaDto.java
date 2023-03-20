package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Direccion;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class CuentaDto {

    private int id;
    private String numero;
    private String tipo;

    private Cliente cliente;

    private Boolean estado;

}
