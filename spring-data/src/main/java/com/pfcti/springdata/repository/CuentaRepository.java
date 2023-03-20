package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    void deleteAllByCliente_Id(int clienteId);
}
