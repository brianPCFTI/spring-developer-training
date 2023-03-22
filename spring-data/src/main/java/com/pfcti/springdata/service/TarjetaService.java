package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.TarjetaDto;
import com.pfcti.springdata.model.Tarjeta;
import com.pfcti.springdata.repository.InversionRepository;
import com.pfcti.springdata.repository.TarjetaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TarjetaService {
    TarjetaRepository tarjetaRepository;

    public Tarjeta cambiarEstadoTarjetaPorIdV2(int id, boolean estado){
        Tarjeta tarjeta = tarjetaRepository.findById(id)
                .orElseThrow(() -> {throw new RuntimeException("tarjetas de Cliente No Existe");});
        tarjeta.setEstado(estado);
        return tarjeta;
    }

    public List<Tarjeta> obtenerTarjetasPorIdCliente(int id){
        List<Tarjeta> resultado = tarjetaRepository.findByCliente_Id(id);
        return resultado;
    }

    public TarjetaDto cambiarEstadoTarjetaPorId(int id, Boolean estado){

       //Consulta la tarjeta
       Tarjeta tarjeta = tarjetaRepository.findById(id)
                .orElseThrow( () -> {
                    throw  new RuntimeException("Tarjeta no existe");
                 });

       //Modifica la entidad
       tarjeta.setEstado(estado);

       //Graba el cambio
       tarjetaRepository.save(tarjeta);

       //Mapea la salida en un DTO
       TarjetaDto tarjetaDto = new TarjetaDto();
       BeanUtils.copyProperties(tarjeta, tarjetaDto);
       return tarjetaDto;

    }

}