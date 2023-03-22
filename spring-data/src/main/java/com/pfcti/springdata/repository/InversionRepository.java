package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Integer> {

    List<Inversion> findByCliente_IdAndEstadoIsTrue(int clienteId);

}
