package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {
    List<Cuenta> findByCliente_IdAndEstadoIsTrue(int clienteId);
    void deleteAllByCliente_Id(int clienteId);

    List<Cuenta> findByNumero(String numero);
    List<Cuenta> findByTipo(String tipo);

}
