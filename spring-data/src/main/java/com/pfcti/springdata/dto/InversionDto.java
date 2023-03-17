package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class InversionDto {

    private int id;
    private String numero;
    private String tipo;
    private Cliente cliente;
}
