package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viajes.service.CiudadService;

@Controller
@RequestMapping ("/gestionciudad")

public class CiudadController {
@Autowired
 private CiudadService ciudadService;

//get----listar, buscar, eliminar
//post....guardar, actualizar
@GetMapping("/lista")
public String listandoCiudades(Model modelito) {
	modelito.addAttribute("mensaje","Bienvenido al modulo de Ciudades");
	modelito.addAttribute("ciudades",ciudadService.listar());
	return "ciudad/listaCiudades";
}
	
	
}
