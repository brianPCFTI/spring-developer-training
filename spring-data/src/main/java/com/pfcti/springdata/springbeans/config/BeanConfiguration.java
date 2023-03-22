package com.pfcti.springdata.springbeans.config;

import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.springbeans.AdministradorClientes;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfiguration {

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean({"defaultCedula" , "criteriaByCedula"}) //Listado de alias del bean
    public AdministradorClientes administradorClientesBean(){
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean("defaultNombres") //Si se un nombre va de esta manera
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //Este es el scope por defecto.
    public AdministradorClientes administradorClientesByNombre() {
        return new AdministradorClientes(clienteRepository,ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresPrototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AdministradorClientes administradorClientesPrototype() {
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean("defaultNombresPrototype")
    @RequestScope
    public AdministradorClientes administradorClientesRequest() {
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean("defaultNombresPrototype")
    @SessionScope
    public AdministradorClientes administradorClientesSesion() {
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

}
