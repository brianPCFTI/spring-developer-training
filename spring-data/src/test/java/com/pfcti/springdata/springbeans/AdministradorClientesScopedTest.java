package com.pfcti.springdata.springbeans;

import com.pfcti.springdata.dto.ClienteDto;
import com.pfcti.springdata.repository.ClienteRepository;
import com.pfcti.springdata.service.ClienteService;
import com.pfcti.springdata.springbeans.dto.ClienteQueryDto;
import com.pfcti.springdata.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdministradorClientesScopedTest {

    @Autowired
    @Qualifier("defaultCedula")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultCedula")
    private AdministradorClientes singleton2;

    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype1;

    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype2;

    @Test
    void instancias() {
        System.out.println("singleton1 " + singleton1);
        System.out.println("singleton2 " + singleton2);
        System.out.println("prototype1 " + prototype1);
        System.out.println("prototype2 " + prototype2);
        Assertions.assertEquals(1, 1);
    }

}