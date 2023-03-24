package com.pfcti.springdata.dto;

import com.pfcti.springdata.model.Direccion;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private int id;
    @NonNull
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String paisNacimiento;
    private List<Direccion> direccions;


}
