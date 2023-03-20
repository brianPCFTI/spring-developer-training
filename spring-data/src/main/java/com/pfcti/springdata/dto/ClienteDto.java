package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Direccion;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {
    private int id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private List<Direccion> direccions;

    private String paisNacimiento;
}
