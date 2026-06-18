package com.viajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.viajes.service.CiudadService;
@SpringBootApplication
public class ViajeSeguroSpringBootApplication implements CommandLineRunner  {

	@Autowired	
	CiudadService serviceCiudad;
		
		
	public static void main(String[] args) {
		SpringApplication.run(ViajeSeguroSpringBootApplication.class, args);
	}

	@Override
	public void run(String ...args)throws Exception{
		System.out.println("-------------------------------");
		System.out.println("Listado de Ciudades");
		System.out.println("-------------------------------");
		serviceCiudad.listar().forEach(c->{
		System.out.println(c.getIdCiudad()+" - "+
		                    c.getNombre()+" - "+
		                    c.getEstado()
		                    );
		});
	}
	
	
}
