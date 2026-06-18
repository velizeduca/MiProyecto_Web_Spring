package com.viajes.service;

import java.util.List;

import com.viajes.entity.Horario;

public interface HorarioService {
	List<Horario> listar();
	void registrarHorario(Horario horario);
	Horario buscarPorId(int id);
	void actualizarHorario(Horario horario);
	void desactivarEstadoHorario(int id);
}