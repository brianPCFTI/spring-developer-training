package com.pfcti.springdata.springbeans.config;

import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.springbeans.AdministradorClientes;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private ClienteRepository clienteRepository;


    @Bean({"defaultCedula" , "criteriaByCedula"}) //Listado de alias del bean
    public AdministradorClientes administradorClientesBean(){
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean("defaultNombres") //Si se un nombre va de esta manera
    public AdministradorClientes administradorClientesByNombre() {
        return new AdministradorClientes(clienteRepository,ClienteQueryType.NOMBRES);
    }

}