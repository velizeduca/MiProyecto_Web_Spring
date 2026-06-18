package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.Bus;
import com.viajes.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService{

@Autowired
private BusRepository repoBus;

@Override
public List<Bus> listar() {
	return repoBus.findAll();
}

@Override
public void registrar(Bus obj) {
	try {
		repoBus.save(obj);
		
	} catch (Exception e) {

	}
	
}

@Override
public void actualizar(Bus obj) {
	try {
		repoBus.save(obj);
	} catch (Exception e) {

	}
	
}

@Override
public void desactivar(int id) {
	Bus b=buscarPorId(id);
	//validar el objeto b
	if(b!=null) {
		b.setEstado("INACTIVO");
		repoBus.save(b);
	}
}

@Override
public Bus buscarPorId(int id) {
	return repoBus.findById(id).orElse(null);
}

}
