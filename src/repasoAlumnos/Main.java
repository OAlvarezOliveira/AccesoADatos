package repasoAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	static Scanner sc = new Scanner(System.in);
	static Path aprobados = Path.of("src/repasoAlumnos/aprobados.txt");
	static Path suspensos = Path.of("src/repasoAlumnos/suspensos.txt");

	public static void main(String[] args) throws IOException {

		menu();

	}

	private static void menu() throws IOException {

		int opcion;
		boolean repiteMenu= true;
		
		while(repiteMenu) {
		System.out.println("1. Crear Alumno");
		System.out.println("2. Guardar Alumnos en Archivos");
		System.out.println("3. Listar Alumnos del sistema");
		System.out.println("4. Salir");
		opcion = sc.nextInt();
        sc.nextLine(); 

		switch (opcion) {
		case 1:  creaAlumno();
		break;

		case 2 : guardaListaAlumnos();
		break;

		case 3 : imprimeListaAlumnos();
		break;
		
		case 4 : 
			System.out.println("Fin de Ejecucion");
			repiteMenu= false;
		break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);

		 }
		}

	}



	private static void imprimeListaAlumnos() {
		
		System.out.println("---------- ListaAlumnos ------------- ");

		for (Alumno elementoLista : listaAlumnos) {

			System.out.println(elementoLista);
		}

	}

private static  void guardaListaAlumnos() throws IOException{

	StringBuilder aprobadosAcumulados = new StringBuilder();
	StringBuilder suspensosAcumulados = new StringBuilder();


	for (Alumno elementoLista : listaAlumnos) {
		String linea = elementoLista.getNombre() +" : "+ elementoLista.getNota()+" \n ";

		if (elementoLista.getNota() >= 5) {

			aprobadosAcumulados.append(linea);
		}

		else 
		{
			suspensosAcumulados.append(linea);

		}
	}

	Files.writeString(aprobados, aprobadosAcumulados,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
	Files.writeString(suspensos, suspensosAcumulados,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
	System.out.println("Archivos Creados y Guardados con Exito");

}
private static void creaAlumno() {
	String nombre;
	double nota;
	boolean continua = true;
	String recursividad;
	


	while(continua) {

		System.out.println("Introduce el nombre del alumno");
		nombre = sc.nextLine(); 

		System.out.println("Introduce la nombre del nota del alumno");
		nota = sc.nextDouble();
		sc.nextLine();

		listaAlumnos.add(new Alumno(nombre,nota));
		System.out.println("Alumno Creado Y Guardado con Exito");

		//recursividad
		System.out.println("¿añadir otro? (s/n)");
		recursividad = sc.nextLine().trim().toUpperCase();
		if(recursividad.equals("N")) {continua= false; break;}

	}

}

}
