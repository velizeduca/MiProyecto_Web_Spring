package com.viajes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.viajes.service.CiudadService;
import com.viajes.service.HorarioService;

@Controller
public class HomeController {
@Autowired
private CiudadService serviceC;
@Autowired
private HorarioService serviceH;


@GetMapping("/")
public String inicio(Model mimodelo) {
mimodelo.addAttribute("ciudades",serviceC.listar());
return "index";
}

//Metodo para buscar horario de viajes
@GetMapping("/buscar")
public String buscandoHorarios(@RequestParam int origen, 
								@RequestParam int destino,
								@RequestParam LocalDate fecha,
								Model mimodelo) {
mimodelo.addAttribute("ciudades",serviceC.listar());
mimodelo.addAttribute("horarios",serviceH.buscarViajes(origen, destino, fecha));
mimodelo.addAttribute("origenSeleccionado",origen);
mimodelo.addAttribute("destinoSeleccionado",destino);
mimodelo.addAttribute("fechaSeleccionada",fecha);
return "index";	
}

	
}
