package com.tienda.online;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.controller.RolController;

import com.tienda.online.model.Rol;




@SpringBootApplication
@RestController
public class TiendaOnlineApplication  implements CommandLineRunner{
	
	@Autowired
	private RolController rolService;
	


	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineApplication.class, args);
		System.out.println("hola");
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		rolService.guardarRol(new Rol(1,"admin","Administrador"));
		rolService.guardarRol(new Rol(2,"admin1","Administrador2"));
		rolService.obtenerTodos().forEach(rol -> {
			System.out.println(rol.getId() +" - " + rol.getDescripcion() + " - "+ rol.getRol());
		});
		
		
		
		
	}
}
