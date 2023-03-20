package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    void deleteById(int clienteId);

    //Consulta JPLSQL
    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);

}
