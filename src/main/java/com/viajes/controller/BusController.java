package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.viajes.entity.Bus;
import com.viajes.entity.MarcaBus;
import com.viajes.service.BusService;

import com.viajes.service.MarcaBusService;


@Controller
@RequestMapping("/gestionbus")

public class BusController {

@Autowired
private BusService serviceB;

@Autowired
private MarcaBusService serviceMB;


@GetMapping ("/lista")
public String listadoBuses(Model model) {
model.addAttribute("mensaje","Bienvenido al modulo de Buses");
model.addAttribute("buses",serviceB.listar());
model.addAttribute("marcas",serviceMB.listar());
//objeto vacio para registrar
Bus bus=new Bus();
bus.setMarcaBus(new MarcaBus());
model.addAttribute("bus",bus);
return "bus/mantBuses";
}

//metodo para registrar Bus
//Servlet....get.....listar, buscar por codigo, eliminar
//Servlet...post---registrar, actualizar
@PostMapping("/registrar")
public String registrarBus(Bus bus, RedirectAttributes redirect) {
serviceB.registrar(bus);
redirect.addFlashAttribute("msg","Bus registrado correctamente");
return "redirect:/gestionbus/lista";
}

//metodo para buscar Bus por codigo
@GetMapping("/buscar/{id}")
@ResponseBody
public Bus BuscarPorId(@PathVariable int id) {
	return serviceB.buscarPorId(id);
}

//metodo para actualizar
@PostMapping("/actualizar")
public String actualizarBus(Bus bus, RedirectAttributes redirect) {
	serviceB.actualizar(bus);
	redirect.addFlashAttribute("msg","Bus actualizado correctamente");
	return "redirect:/gestionbus/lista";
}

//metodo para cambiar el estado de bUs
@GetMapping("/desactivar/{id}")
public String desactivarEstado(@PathVariable int id, RedirectAttributes redirect) {
	serviceB.desactivar(id);	
	redirect.addFlashAttribute("msg","Bus desactivado correctamente");
	return "redirect:/gestionbus/lista";
}




	
	
}
