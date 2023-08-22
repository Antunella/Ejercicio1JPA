package com.utn.ejercicio1;

import com.utn.ejercicio1.entidades.Persona;
import com.utn.ejercicio1.repositorios.PersonaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);

		System.out.println("-----------------ESTOY FUNCIONANDO---------");

		ConfigurableApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);

		// Crear un objeto Persona
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Pérez");
		persona.setEdad(30);

		// Guardar el objeto Persona en la base de datos
		PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
		personaRepository.save(persona);

		// Recuperar el objeto Persona desde la base de datos
		Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
		if (personaRecuperada != null) {
			System.out.println("Nombre: " + personaRecuperada.getNombre());
			System.out.println("Apellido: " + personaRecuperada.getApellido());
			System.out.println("Edad: " + personaRecuperada.getEdad());
		}

		context.close();
	}
}

