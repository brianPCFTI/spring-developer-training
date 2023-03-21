package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cliente;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    List<Tarjeta> findByCliente_IdAndEstadoIsTrue(int clienteId);

}
