package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    void deleteById(int clienteId);

    //Consulta JPLSQL
    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);

    //Consuta nativa
    @Query(value = "select nombre,apellidos,cedula,telefono,id from cliente where apellidos := apellidos",
            nativeQuery = true)
    List<Tuple>  buscarPorApellidosNativo(String apellidos);

    //Challenge
    //List<Cliente> findClientesByPaisNacimientoContainsAndTarjeta

    List<Cliente> findByCedula(String cedula);
    List<Cliente> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombres, String apellidos);

}
