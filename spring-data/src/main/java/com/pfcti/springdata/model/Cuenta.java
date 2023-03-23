package com.pfcti.springdata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //NotBlank valida no nulo con al menos 1 caracter
    @NotBlank(message = "Numero de cuenta es mandatorio")
    @NotNull(message = "Numero de cuenta no debe ser null")
    @Size(min = 1, message = "Numero de cuenta debe tener minimo un caracter")
    private String numero;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    private Boolean estado;

}
