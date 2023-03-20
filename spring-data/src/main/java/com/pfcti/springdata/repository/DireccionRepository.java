package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}
