package com.viajes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.viajes.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer>{

	//impelmentando una consulta jpql
	@Query("""
			SELECT h FROM Horario h
			WHERE h.ruta.ciudadOrigen.idCiudad=:origen
			AND h.ruta.ciudadDestino.idCiudad=:destino
			AND h.fechaSalida=:fecha
			""")
	List<Horario>buscarViajes(@Param("origen")int origen,
			                  @Param("destino")int destino,
			                  @Param("fecha")LocalDate fecha);
}
