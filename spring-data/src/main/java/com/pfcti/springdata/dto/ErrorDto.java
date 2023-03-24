package com.pfcti.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private Integer status;
    private int codigo;
    private String mensaje;

    public ErrorDto (Integer status, String message){
      this.mensaje =message;
      this.status = status;
    }

}
