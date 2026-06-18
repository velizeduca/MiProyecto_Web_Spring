package com.viajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viajes.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

}
