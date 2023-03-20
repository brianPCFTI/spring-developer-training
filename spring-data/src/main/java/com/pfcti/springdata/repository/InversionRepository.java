package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Integer> {
}
