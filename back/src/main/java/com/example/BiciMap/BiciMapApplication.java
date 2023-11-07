package com.example.BiciMap;

import com.example.BiciMap.modelo.Usuarios;
import com.example.BiciMap.repositorio.UsuarioRepository;
import com.github.javafaker.Faker;
import menus.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import usuarios.ArbolUsuarios;
import usuarios.PilaUsuarios;

import java.util.Scanner;

@SpringBootApplication
public class BiciMapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BiciMapApplication.class, args);
	}
	@Autowired
	private UsuarioRepository repo;
	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		ArbolUsuarios arbolUsuarios = new ArbolUsuarios();
		ArbolUsuarios.BST arbolBST = arbolUsuarios.new BST();





		for (int i=0; i<1000;i++){
			Usuarios user =new Usuarios();
			String nombre = faker.name().firstName(); // Miss Samanta Schmidt
			String apellido = faker.name().lastName(); // Emory
			String email = faker.internet().emailAddress(); // Barton
			String contraseña = faker.internet().password();
			String direccion = faker.address().fullAddress();
			String localidad = faker.address().streetName();

			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setCorreoElectronico(email);
			user.setContraseña(contraseña);
			user.setUbicacionActual(direccion);
			user.setLocalidad(localidad);
			//repo.save(user);
			arbolBST.insertar(user);
			System.out.println(user);







		}


		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingresa el correo electrónico a buscar para eliminar : ");
		String correoBuscado = scanner.nextLine();
		System.out.print("Ingresa el apellido : ");
		String apellido2 = scanner.nextLine();

		long startTime = System.nanoTime();

		Usuarios nuevoUsuario = new Usuarios();
		nuevoUsuario.setApellido(apellido2); // Establece solo el apellido actualizado


		arbolBST.actualizar(correoBuscado,nuevoUsuario);
		Usuarios  usua=arbolBST.buscar(correoBuscado);


		System.out.println("Usuario modificado: " + usua);


		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;

		System.out.println("Tiempo de ejecución: " + executionTime + " nanosegundos");




	}
	/*
	public static void main(String[] args) {
		SpringApplication.run(BiciMapApplication.class, args);


		Scanner scanner = new Scanner(System.in);
		String titulo = "*****************************************************************\n"+
				"                               ,o\n" +
				"                           __ <<<<__\n" +
				"                          (_)       (_)  ";

		// Imprimir el título

		// Imprimir el título
		System.out.println(titulo);

		System.out.println("Bienvenidos a BiciMap. Por favor, elige una de nuestras opciones:");
		System.out.println("1. Rutas Favoritas");
		System.out.println("2. Historial de Rutas");
		System.out.println("3. Usuarios");
		System.out.println("4. Rutas");
		System.out.println("5. Salir");

		int opcion = scanner.nextInt();

		switch (opcion) {
			case 1:

				FavoritosMenu.main(args);
				break;
			case 2:

				HistorialMenu.main(args);
				break;
			case 3:

				MenuPilaUsuarios.main(args);
				break;

			case 4:

				mainNodePointMenu.main(args);

				break;
			case 5:
				System.out.println("Gracias por usar BiciMap. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, elige una opción válida.");
				break;
		}
	}
*/

}
