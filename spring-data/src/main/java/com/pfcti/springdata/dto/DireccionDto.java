package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class DireccionDto {

    private int id;
    private String direccion;
    private String nomenclatura;

    private Cliente cliente;
}
