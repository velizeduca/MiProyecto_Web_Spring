package com.viajes.service;
import java.util.List;
import com.viajes.entity.Bus;

public interface BusService {

List<Bus>listar();
void registrar(Bus obj);
void actualizar(Bus obj);
void desactivar(int id);
Bus buscarPorId(int id);
	
}
