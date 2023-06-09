package com.pfcti.springdata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cliente")
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    @NotNull(message = "Name cannot be null")
    private String nombre;
    @Column(length = 30)
    private String apellidos;
    @Column(columnDefinition = "varchar(15)")
    private String cedula;
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direccions;

    private String paisNacimiento;


    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;
}
